package com.maksimyurau.android.lab11_reddit.data.repository

import androidx.lifecycle.LiveData
import com.maksimyurau.android.lab11_reddit.model.PostModel

interface Repository {

  fun getAllPosts(): LiveData<List<PostModel>>

  fun getAllOwnedPosts(): LiveData<List<PostModel>>

  fun getAllSubreddits(searchedText: String): List<String>

  fun insert(post: PostModel)

  fun deleteAll()
}