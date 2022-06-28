package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.Info.InfoFollowFragment
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchAccountBinding
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBestBinding
import com.example.umc_android_instagram_clone_coding.databinding.ItemSearchAccountBinding
import com.google.firebase.firestore.FirebaseFirestore

class SearchBestFragment: Fragment() {
    lateinit var binding: FragmentSearchBestBinding
    private var accountDatas = ArrayList<User>()

    var firestore : FirebaseFirestore? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBestBinding.inflate(inflater, container, false)

//        // 파이어스토어 인스턴스 초기화
//        firestore = FirebaseFirestore.getInstance()

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        accountDatas.apply {
            add(User(name = "luna", realname = "고지민", profileImg = R.drawable.info))
            add(User(name = "harry", realname = "이승희", profileImg = R.drawable.info))
            add(User(name = "cocoa", realname = "김나현", profileImg = R.drawable.info))
            add(User(name = "bori", realname = "정조은", profileImg = R.drawable.info))
            add(User(name = "ginie", realname = "강어진", profileImg = R.drawable.info))
            add(User(name = "ally", realname = "박수빈", profileImg = R.drawable.info))
            add(User(name = "ark", realname = "박승민", profileImg = R.drawable.info))
            add(User(name = "blue", realname = "이서현", profileImg = R.drawable.info))
            add(User(name = "ddobby", realname = "김도연", profileImg = R.drawable.info))
            add(User(name = "tama", realname = "서동주", profileImg = R.drawable.info))
            add(User(name = "seora", realname = "설지은", profileImg = R.drawable.info))
        }

        val searchAccountRVAdapter = SearchAccountRVAdapter(accountDatas) // 더미데이터랑 Adapter 연결
        binding.searchBestRv.adapter = searchAccountRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.searchBestRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

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

// 파이어베이스 검색 기능 구현 실패...
//    lateinit var binding: FragmentSearchBestBinding
//
//    var firestore: FirebaseFirestore? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // 파이어스토어 인스턴스 초기화
//        firestore = FirebaseFirestore.getInstance()
//
//        val searchBestRVAdapter = RecyclerViewAdapter()
//        binding.searchBestRv.adapter = searchBestRVAdapter
//        binding.searchBestRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//    }
//
//    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//        // User 클래스 ArrayList 생성성
//        var User: ArrayList<User> = arrayListOf()
//
//        init {  // User의 문서를 불러온 뒤 User으로 변환해 ArrayList에 담음
//            firestore?.collection("User")
//                ?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
//                    // ArrayList 비워줌
//                    User.clear()
//
//                    for (snapshot in querySnapshot!!.documents) {
//                        var item = snapshot.toObject(User()::class.java)
//                        User.add(item!!)
//                    }
//                    notifyDataSetChanged()
//                }
//        }
//
//        // xml파일을 inflate하여 ViewHolder를 생성
//        override fun onCreateViewHolder (viewGroup: ViewGroup, viewType: Int) : ViewHolder{
//            var binding: ItemSearchAccountBinding =
//                ItemSearchAccountBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//
//            return ViewHolder(binding)
//        }
//
//        // onCreateViewHolder에서 만든 view와 실제 데이터를 연결
//        inner class ViewHolder(val binding: ItemSearchAccountBinding) : RecyclerView.ViewHolder(binding.root) {
//            fun bind(user: User) {
//                binding.itemSearchAccountUserProfileIv.setImageResource(user.profileImg!!)
//                binding.itemSearchAccountUserIDTv.text = user.name
//                binding.itemSearchAccountUsernameTv.text = user.realname
////                binding.itemSearchAccountUserProfileIv.setImageResource(user.profileImg!!)
////                binding.itemSearchAccountUserIDTv.text = user.name
////                binding.itemSearchAccountUsernameTv.text = user.realname
//            }
//        }
//
//        // 리사이클러뷰의 아이템 총 개수 반환
//        override fun getItemCount(): Int {
//            return User.size
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentSearchBestBinding.inflate(inflater, container, false)
//
//        return binding.root
//    }