package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchDetailFragment: Fragment() {
    lateinit var binding: FragmentSearchDetailBinding

    private val information = arrayListOf("인기", "계정", "오디오", "태그", "장소")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchDetailBinding.inflate(inflater, container, false)

        /* Fragment 전환 */
        binding.searchDetailBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_fl, SearchFragment()).commitAllowingStateLoss()
        }

        /* TabLayout, ViewPager 전환 */
        val searchDetailAdapter = SearchDetailVPAdapter(this)
        binding.searchDetailContentVp.adapter = searchDetailAdapter
        TabLayoutMediator(binding.searchDetailContentTb, binding.searchDetailContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }
}