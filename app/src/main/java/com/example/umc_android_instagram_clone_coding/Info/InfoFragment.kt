package com.example.umc_android_instagram_clone_coding.Info

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private val tabIconArray = arrayOf(
        R.drawable.info_feed_tab,
        R.drawable.info_tag_tab
    )
//misc 충돌 에러 c
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectViewPager()  // 뷰페이저 연결
        editProfileClickEvent()  // 프로필설정 버튼 클릭 이벤트
    }
    private fun connectViewPager() {
        val infoAdapter = InfoVPAdapter(this)
        binding.infoVp.adapter = infoAdapter  // InfoFragment 뷰페이저에 어댑터 연결

        TabLayoutMediator(binding.infoTb, binding.infoVp){ tab, position ->  // 탭 레이아웃, 뷰페이저 연결
            tab.icon = ResourcesCompat.getDrawable(resources, tabIconArray[position], null)
        }.attach()
    }

    private fun editProfileClickEvent() {
        binding.infoEditProfileBt.setOnClickListener{
            startActivity(Intent(activity, InfoEditActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
