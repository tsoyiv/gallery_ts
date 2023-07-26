package com.example.galleryapp.presenter

import com.example.galleryapp.api.Photo
import com.example.galleryapp.model.PhotoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotoPresenter(private val view: PhotoContract.View, private val model: PhotoModel) :
    PhotoContract.Presenter {

    override fun loadPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val photos = model.getAllPhotos()
                view.displayPhotos(photos)
            } catch (e: Exception) {
                view.displayError("Error loading photos.")
            }
        }
    }
    override fun insertPhoto(photo: Photo) {
        GlobalScope.launch(Dispatchers.IO) {
            model.insertPhoto(photo)
        }
    }
    override fun deleteAllPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                model.deleteAllPhotos()
                view.displayPhotos(emptyList())
            } catch (e: Exception) {
                view.displayError("Error deleting photos.")
            }
        }
    }
}
