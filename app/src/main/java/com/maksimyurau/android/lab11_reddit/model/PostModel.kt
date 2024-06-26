package com.maksimyurau.android.lab11_reddit.model


import com.maksimyurau.android.lab11_reddit.R

data class PostModel(
  val username: String,
  val subreddit: String,
  val title: String,
  val text: String,
  val likes: String,
  val comments: String,
  val type: PostType,
  val postedTime: String,
  val image: Int?
) {

  companion object {

    val DEFAULT_POST = PostModel(
      "raywenderlich",
      "androiddev",
      "Watch this awesome Jetpack Compose course!",
      "",
      "5614",
      "523",
      PostType.IMAGE,
      "4h",
      R.drawable.compose_course
    )

    val EMPTY = PostModel(
      "raywenderlich",
      "raywenderlich.com",
      "",
      "",
      "0",
      "0",
      PostType.TEXT,
      "0h",
      R.drawable.compose_course
    )
  }
}