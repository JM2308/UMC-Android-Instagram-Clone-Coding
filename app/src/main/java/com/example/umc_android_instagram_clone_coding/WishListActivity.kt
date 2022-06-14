package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityWishListBinding

class WishListActivity : AppCompatActivity() {
    lateinit var binding: ActivityWishListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wishlistBackIv.setOnClickListener {
            finish()
        }
    }
}