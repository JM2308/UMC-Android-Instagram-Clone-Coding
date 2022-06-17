package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)

        binding.signupNumberConnect.setOnClickListener {
            startActivity(Intent(this, SignupBirthdayActivity::class.java))
        }

        binding.signupNumberDisconnect.setOnClickListener {
            startActivity(Intent(this, SignupBirthdayActivity::class.java))
        }

        setContentView(binding.root)
    }
}