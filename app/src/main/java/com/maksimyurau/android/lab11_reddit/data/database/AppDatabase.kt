package com.maksimyurau.android.lab11_reddit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maksimyurau.android.lab11_reddit.data.database.dao.PostDao
import com.maksimyurau.android.lab11_reddit.data.database.model.PostDbModel

/**
 * База данных приложения.
 *
 * Содержит таблицу для постов
 */
@Database(entities = [PostDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

  companion object {
    const val DATABASE_NAME = "jet-reddit-database"
  }

  abstract fun postDao(): PostDao
}