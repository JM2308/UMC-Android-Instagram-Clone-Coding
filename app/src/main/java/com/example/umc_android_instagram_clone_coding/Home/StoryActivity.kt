package com.example.umc_android_instagram_clone_coding.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivityHomeStoryBinding

class StoryActivity: AppCompatActivity() {

    lateinit var binding: ActivityHomeStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storyHeartIv.setOnClickListener {
            binding.storyHeartIv.setImageResource(R.drawable.heart_red)
        }

        binding.storyCloseIv.setOnClickListener {
            finish()
        }
    }
}