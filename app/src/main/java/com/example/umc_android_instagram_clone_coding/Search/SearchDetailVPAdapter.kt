package com.example.umc_android_instagram_clone_coding.Search

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchDetailVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SearchBestFragment()
            1 -> SearchAccountFragment()
            2 -> SearchAudioFragment()
            3 -> SearchPlaceFragment()
            else -> SearchTagFragment()
        }
    }
}