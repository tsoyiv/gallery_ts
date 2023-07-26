package com.example.galleryapp.api

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos_table")
    fun getAllPhotos(): LiveData<List<Photo>>

    @Insert
    fun insertPhoto(item: Photo)

    @Delete
    fun deletePhoto(item: Photo)
}