package com.example.galleryapp.model

import com.example.galleryapp.api.Photo

interface PhotoModel {
    suspend fun insertPhoto(photo: Photo)
    suspend fun getAllPhotos(): List<Photo>
    suspend fun deleteAllPhotos()
}