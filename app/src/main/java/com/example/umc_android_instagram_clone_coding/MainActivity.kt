package com.example.umc_android_instagram_clone_coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.view.WindowManager
import com.example.umc_android_instagram_clone_coding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

=======
import com.example.umc_android_instagram_clone_coding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
>>>>>>> 0e7f7785e46f4e8a1ea4073d47e9aa9ca731b42f
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
=======
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fl, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.reelsFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, ReelsFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.shopFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, ShopFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.infoFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, InfoFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
>>>>>>> 0e7f7785e46f4e8a1ea4073d47e9aa9ca731b42f
    }
}