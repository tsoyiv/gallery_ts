package com.example.galleryapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.databinding.FragmentMainBinding
import com.example.galleryapp.utils.PhotoAdapter

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRc()
    }

    private fun setupRc() {
        recyclerView = binding.rcView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        photoAdapter = PhotoAdapter(emptyList())
        recyclerView.adapter = photoAdapter
    }
}