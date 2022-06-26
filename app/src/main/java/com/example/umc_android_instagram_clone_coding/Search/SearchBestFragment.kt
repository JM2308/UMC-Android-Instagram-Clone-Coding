package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Account
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.Data.Shop
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.Info.InfoFollowFragment
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchAccountBinding
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBestBinding
import com.google.firebase.firestore.FirebaseFirestore

class SearchBestFragment: Fragment() {

    lateinit var binding: FragmentSearchBestBinding
    private var accountDatas = ArrayList<Account>()

    var firestore : FirebaseFirestore? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBestBinding.inflate(inflater, container, false)

        // 파이어스토어 인스턴스 초기화
        firestore = FirebaseFirestore.getInstance()

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        accountDatas.apply {
            add(Account("ex1","이름1", R.drawable.info))
            add(Account("ex2","이름2", R.drawable.info))
            add(Account("ex3","이름3", R.drawable.info))
            add(Account("ex4","이름4", R.drawable.info))
            add(Account("ex5","이름5", R.drawable.info))
        }

        val searchAccountRVAdapter = SearchAccountRVAdapter(accountDatas) // 더미데이터랑 Adapter 연결
        binding.searchBestRv.adapter = searchAccountRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.searchBestRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // search account 리사이클러뷰 아이템 클릭 전환
        searchAccountRVAdapter.setMyItemclickListener(object: SearchAccountRVAdapter.MyItemClickListener{
            override fun onItemClick() {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fl, InfoFollowFragment())
                    .commitAllowingStateLoss()
            }
        })

        return binding.root
    }

//    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//        // User 클래스 ArrayList 생성성
//        var account: ArrayList<User> = arrayListOf()
//
//        init {  // telephoneBook의 문서를 불러온 뒤 Person으로 변환해 ArrayList에 담음
//            firestore?.collection("account")
//                ?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
//                    // ArrayList 비워줌
//                    account.clear()
//
//                    for (snapshot in querySnapshot!!.documents) {
//                        var item = snapshot.toObject(User::class.java)
//                        account.add(item!!)
//                    }
//                    notifyDataSetChanged()
//                }
//        }
//    }
}