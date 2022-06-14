package com.example.umc_android_instagram_clone_coding

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// InfoFragment 뷰페이저 어댑터
class InfoVPAdapter (fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int  = 2
    override fun createFragment(position: Int): Fragment {
        return when(position){  // 프레그먼트 포지션에 따른 프레그먼트 띄우기
            0 -> InfoPostFragment()
            else -> InfoTagFragment()
        }
    }
}