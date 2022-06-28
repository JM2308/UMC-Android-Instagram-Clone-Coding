package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Account
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.Data.Shop
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.Info.InfoFollowFragment
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchAccountBinding
import com.google.firebase.firestore.FirebaseFirestore

class SearchAccountFragment: Fragment() {

    lateinit var binding: FragmentSearchAccountBinding
    private var accountDatas = ArrayList<User>()

    var firestore : FirebaseFirestore? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchAccountBinding.inflate(inflater, container, false)

//        // 파이어스토어 인스턴스 초기화
//        firestore = FirebaseFirestore.getInstance()

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        accountDatas.apply {
            add(User(name = "luna", realname = "고지민", profileImg = R.drawable.info))
            add(User(name = "harry", realname = "이승희", profileImg = R.drawable.info))
            add(User(name = "cocoa", realname = "김나현", profileImg = R.drawable.info))
        }

        val searchAccountRVAdapter = SearchAccountRVAdapter(accountDatas) // 더미데이터랑 Adapter 연결
        binding.searchAccountRv.adapter = searchAccountRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.searchAccountRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // search account 리사이클러뷰 아이템 클릭 전환
        searchAccountRVAdapter.setMyItemclickListener(object: SearchAccountRVAdapter.MyItemClickListener{
            override fun onItemClick(user: User) {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fl, InfoFollowFragment())
                    .commitAllowingStateLoss()
            }
        })

        return binding.root
    }
}