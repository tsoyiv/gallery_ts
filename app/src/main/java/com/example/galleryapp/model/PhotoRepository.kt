package com.example.galleryapp.model

import com.example.galleryapp.api.Photo
import com.example.galleryapp.api.PhotoDao

class PhotoRepository(private val photoDao: PhotoDao) : PhotoModel {
    override suspend fun insertPhoto(photo: Photo) {
        photoDao.insertPhoto(photo)
    }

    override suspend fun getAllPhotos(): List<Photo> {
        return photoDao.getAllPhotos()
    }

    override suspend fun deleteAllPhotos() {
        photoDao.deleteAllPhotos()
    }
}