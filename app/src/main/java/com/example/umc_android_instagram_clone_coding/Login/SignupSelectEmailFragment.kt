package com.example.umc_android_instagram_clone_coding.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoTagBinding
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSignupSelectEmailBinding

class SignupSelectEmailFragment: Fragment() {

    lateinit var binding : FragmentSignupSelectEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupSelectEmailBinding.inflate(inflater, container, false)

        return binding.root
    }
}