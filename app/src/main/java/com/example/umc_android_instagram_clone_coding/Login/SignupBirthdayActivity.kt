package com.example.umc_android_instagram_clone_coding.Login

import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupBirthdayBinding

class SignupBirthdayActivity: AppCompatActivity() {

    lateinit var binding : ActivitySignupBirthdayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBirthdayBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}