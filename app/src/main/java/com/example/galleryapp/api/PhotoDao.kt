package com.example.galleryapp.api

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photos_table")
    fun getAllPhotos(): List<Photo>

    @Insert
    fun insertPhoto(item: Photo)

    @Query("DELETE FROM photos_table")
    fun deleteAllPhotos()
}