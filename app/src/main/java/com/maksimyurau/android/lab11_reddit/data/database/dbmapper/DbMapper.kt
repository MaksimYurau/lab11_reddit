package com.maksimyurau.android.lab11_reddit.data.database.dbmapper

import com.maksimyurau.android.lab11_reddit.data.database.model.PostDbModel
import com.maksimyurau.android.lab11_reddit.model.PostModel

interface DbMapper {

  fun mapPost(dbPostDbModel: PostDbModel): PostModel

  fun mapDbPost(postModel: PostModel): PostDbModel
}