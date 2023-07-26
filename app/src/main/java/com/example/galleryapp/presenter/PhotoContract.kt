package com.example.galleryapp.presenter

import com.example.galleryapp.api.Photo

interface PhotoContract {
    interface View {
        fun displayPhotos(photos: List<Photo>)
        fun displayError(message: String)
    }

    interface Presenter {
        fun loadPhotos()
        fun deleteAllPhotos()
        fun insertPhoto(photo: Photo)
    }

    interface Model {
        fun getAllPhotos(): List<Photo>
        fun insertPhoto(photo: Photo)
    }
}
