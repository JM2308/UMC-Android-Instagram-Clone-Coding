package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupAgreeBinding

class SignupAgreeActivity: AppCompatActivity() {

    lateinit var binding : ActivitySignupAgreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupAgreeBinding.inflate(layoutInflater)

        binding.signupAgreeNextBtn.setOnClickListener {
            startActivity(Intent(this, SignupLastCheckActivity::class.java))
        }

        setContentView(binding.root)
    }
}