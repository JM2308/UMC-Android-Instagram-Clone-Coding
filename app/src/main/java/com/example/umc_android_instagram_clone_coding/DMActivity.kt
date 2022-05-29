package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityDmBinding

class DMActivity : AppCompatActivity() {

    lateinit var binding : ActivityDmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDmBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}