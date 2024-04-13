package com.maksimyurau.android.lab11_reddit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maksimyurau.android.lab11_reddit.data.repository.Repository
import com.maksimyurau.android.lab11_reddit.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val allPosts by lazy { repository.getAllPosts() }

    val myPosts by lazy { repository.getAllOwnedPosts() }

    val subreddits by lazy { MutableLiveData<List<String>>() }

    val selectedCommunity: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun searchCommunities(searchedText: String) {
        viewModelScope.launch(Dispatchers.Default) {
            subreddits.postValue(repository.getAllSubreddits(searchedText))
        }
    }

    fun savePost(post: PostModel) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.insert(post.copy(subreddit = selectedCommunity.value ?: ""))
        }
    }
}