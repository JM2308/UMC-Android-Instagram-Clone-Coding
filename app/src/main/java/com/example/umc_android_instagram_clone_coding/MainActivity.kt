package com.example.umc_android_instagram_clone_coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_android_instagram_clone_coding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {  // 바텀 네비게이션
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fl, HomeFragment())  // 시작 화면은 홈
            .commitAllowingStateLoss()

        binding.mainBottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {  // 홈 화면
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {  // 검색 화면
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.reelsFragment -> {  // 릴스 화면
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, ReelsFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.shopFragment -> {  // 쇼핑 화면
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, ShopFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.infoFragment -> {  // 내 정보 화면
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fl, InfoFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}