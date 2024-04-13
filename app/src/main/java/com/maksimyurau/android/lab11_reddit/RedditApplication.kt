package com.maksimyurau.android.lab11_reddit

import android.app.Application
import com.maksimyurau.android.lab11_reddit.dependencyinjection.DependencyInjector

class RedditApplication : Application() {

  lateinit var dependencyInjector: DependencyInjector

  override fun onCreate() {
    super.onCreate()
    initDependencyInjector()
  }

  private fun initDependencyInjector() {
    dependencyInjector = DependencyInjector(this)
  }
}