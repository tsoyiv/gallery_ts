package com.example.galleryapp.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun itemDao(): PhotoDao

    companion object {
        private var INSTANCE: PhotoDatabase? = null

        fun getInstance(context: Context): PhotoDatabase {
            if (INSTANCE == null) {
                synchronized(PhotoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PhotoDatabase::class.java,
                        "app_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}