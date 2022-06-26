package com.example.umc_android_instagram_clone_coding.Info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private var firestore : FirebaseFirestore? = null
    private var uid : String? = null
    private lateinit var documentId: String

    private val tabIconArray = arrayOf(
        R.drawable.info_feed_tab,
        R.drawable.info_tag_tab
    )

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

        uid = FirebaseAuth.getInstance().currentUser?.uid  // 유저 고유 아이디 초기화
        firestore = FirebaseFirestore.getInstance()  // 파이어베이스 파이어스토어 db 가져오기

        val db = firestore?.collection("User")
        db?.whereEqualTo("uid", uid) // uid가 현재 로그인한 uid랑 같은 문서 찾기
            ?.get()
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    for (dc in it.result!!.documents) {
                        val user = dc.toObject(User::class.java)

                            binding.infoIdTv.text = user?.name // 유저 닉네임

                        binding.infoNameTv.text = user?.realname
                        if (binding.infoNameTv.text != null && binding.infoNameTv.text != "") {  // 빈칸이 아니면 본명 비지블맨
                            binding.infoNameTv.visibility = View.VISIBLE
                        }

                        binding.infoIntroTv.text = user?.introduce
                        if (binding.infoIntroTv.text != null && binding.infoIntroTv.text != "") {  // 빈칸이 아니면 소개 비지블맨
                            binding.infoIntroTv.visibility = View.VISIBLE
                        }

                        binding.infoWebSiteTv.text = user?.link
                        if (binding.infoWebSiteTv.text != null && binding.infoWebSiteTv.text != "") {  // 빈칸이 아니면 웹사이트 비지블맨
                            binding.infoWebSiteTv.visibility = View.VISIBLE
                        }

                        documentId = dc.id // 자동생성 문서 id  ex)775wWEzUVjXiyAGDc5O4

                        if (user?.profileImg != 0)  // 유저가 프로필을 설정했으면 적용
                            binding.infoProfileIv.setImageResource(user?.profileImg!!)
                        if (user?.post != null)  // 게시물이 한 개라도 있으면 숫자 카운팅
                            binding.infoNumberOfPostsTv.text = user?.post?.size.toString()
                        if (user?.follower != null)  // 팔로워가 한 명이라도 있으면 숫자 카운팅
                            binding.infoNumberOfFollowerTv.text = user?.follower?.size.toString()
                        if (user?.following != null)  // 팔로잉가 한 명이라도 있으면 숫자 카운팅
                           binding.infoNumberOfFollowingTv.text = user?.following?.size.toString()
                    }
                }
            }
        connectViewPager()  // 뷰페이저 연결
        editProfileClickEvent()  // 프로필설정 버튼 클릭 이벤트
        dialogClickEvent()  // 메뉴 클릭 이벤트
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
            val intent = Intent(context, InfoEditActivity::class.java)
            intent.putExtra("documentId",documentId)
            startActivity(intent)
        }
    }
    private fun dialogClickEvent() {
        binding.infoMenuIv.setOnClickListener {
            val bottomSheet = InfoMenuFragment()
            fragmentManager?.let { it1 -> bottomSheet.show(it1, bottomSheet.tag) }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
