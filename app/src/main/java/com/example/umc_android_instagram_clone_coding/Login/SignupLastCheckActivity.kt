package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupLastCheckBinding

class SignupLastCheckActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupLastCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupLastCheckBinding.inflate(layoutInflater)

        binding.signupCheckSignupBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        setContentView(binding.root)
    }
}