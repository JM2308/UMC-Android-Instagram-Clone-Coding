package com.example.umc_android_instagram_clone_coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_android_instagram_clone_coding.databinding.ActivityInfoEditBinding

class InfoEditActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInfoEditBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.infoEditCloseIv.setOnClickListener{
            finish()
        }
    }
}