package com.maksimyurau.android.lab11_reddit.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.maksimyurau.android.lab11_reddit.data.database.AppDatabase
import com.maksimyurau.android.lab11_reddit.data.database.dbmapper.DbMapper
import com.maksimyurau.android.lab11_reddit.data.database.dbmapper.DbMapperImpl
import com.maksimyurau.android.lab11_reddit.data.repository.Repository
import com.maksimyurau.android.lab11_reddit.data.repository.RepositoryImpl
import kotlinx.coroutines.DelicateCoroutinesApi

/**
 * Обеспечивает зависимости через приложение.
 */
class DependencyInjector(applicationContext: Context) {
    val repository: Repository by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }
    private val dbMapper: DbMapper = DbMapperImpl()

    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    @OptIn(DelicateCoroutinesApi::class)
    private fun provideRepository(database: AppDatabase): Repository {
        val postDao = database.postDao()

        return RepositoryImpl(postDao, dbMapper)
    }
}