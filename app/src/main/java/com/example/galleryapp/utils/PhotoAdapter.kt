package com.example.galleryapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.api.Photo

class PhotoAdapter(private var photos: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_photo)
        val txt_date: TextView = itemView.findViewById(R.id.txt_dateCreated)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]

        holder.txt_date.text = photo.dateCreated
        Glide.with(holder.imageView)
            .load(photo.photoUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun updatePhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }
}