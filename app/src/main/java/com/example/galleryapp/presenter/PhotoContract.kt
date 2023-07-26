package com.example.galleryapp.presenter

import com.example.galleryapp.api.Photo

interface PhotoContract {
    interface View {
        fun showPhotos(photos: List<Photo>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun loadPhotos()
        fun capturePhoto(newPhoto: String)
    }
}