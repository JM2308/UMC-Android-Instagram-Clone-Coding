package com.example.umc_android_instagram_clone_coding.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSignupSelectNumberBinding

class SignupSelectNumberFragment: Fragment() {

    lateinit var binding: FragmentSignupSelectNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupSelectNumberBinding.inflate(inflater, container, false)

        return binding.root
    }
}