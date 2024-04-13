package com.maksimyurau.android.lab11_reddit

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.maksimyurau.android.lab11_reddit.viewmodel.MainViewModel
import com.maksimyurau.android.lab11_reddit.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as RedditApplication).dependencyInjector.repository
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RedditApp(viewModel)
        }
    }
}