package com.example.galleryapp.api

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_table")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val dateCreated: String,
    val directory: String,
    val longitude: String,
    val latitude: String,
    val photoUrl: Bitmap
)
