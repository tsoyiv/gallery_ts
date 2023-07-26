package com.example.galleryapp.presenter

import com.example.galleryapp.api.Photo
import com.example.galleryapp.api.PhotoDao
import java.text.SimpleDateFormat
import java.util.*

class PhotoPresenter(private val photoDao: PhotoDao) : PhotoContract.Presenter {

    private var view: PhotoContract.View? = null

    override fun attachView(view: PhotoContract.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadPhotos() {
        photoDao.getAllPhotos().observeForever { photos ->
            view?.showPhotos(photos)
        }
    }

    override fun capturePhoto(newPhoto: String) {
        val dateCreated = SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.getDefault()).format(Date())
        val photo = Photo(dateCreated = dateCreated, photoUrl = newPhoto)
        photoDao.insertPhoto(photo)
    }
}
