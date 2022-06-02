package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private val tabIconArray = arrayOf(
        R.drawable.info_feed_tab,
        R.drawable.info_tag_tab
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)

        val infoAdapter = InfoVPAdapter(this)
        binding.infoVp.adapter = infoAdapter  // InfoFragment 뷰페이저에 어댑터 연결

        TabLayoutMediator(binding.infoTb, binding.infoVp){ tab, position ->  // 탭 레이아웃, 뷰페이저 연결
            tab.icon = ResourcesCompat.getDrawable(resources, tabIconArray[position], null)
        }.attach()

        return binding.root
    }
}
