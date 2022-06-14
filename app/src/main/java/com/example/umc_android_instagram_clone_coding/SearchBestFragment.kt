package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBestBinding

class SearchBestFragment: Fragment() {
    lateinit var binding: FragmentSearchBestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBestBinding.inflate(inflater, container, false)
        return binding.root
    }
}