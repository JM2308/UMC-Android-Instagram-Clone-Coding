package com.example.umc_android_instagram_clone_coding.Shop

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.LoginActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityShopWishListBinding

class WishListActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopWishListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopWishListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wishlistBackIv.setOnClickListener {
            finish()
        }
    }
}