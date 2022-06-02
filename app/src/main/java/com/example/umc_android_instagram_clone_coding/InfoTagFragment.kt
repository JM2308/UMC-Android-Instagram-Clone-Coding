package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoTagBinding

class InfoTagFragment : Fragment() {
    lateinit var binding: FragmentInfoTagBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoTagBinding.inflate(inflater, container, false)

        return binding.root
    }
}