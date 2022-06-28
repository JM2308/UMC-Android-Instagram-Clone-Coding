package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBestBinding
import com.example.umc_android_instagram_clone_coding.databinding.ItemSearchAccountBinding
import com.google.firebase.firestore.FirebaseFirestore

class SearchBestFragment: Fragment() {

    lateinit var binding: FragmentSearchBestBinding

    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 파이어스토어 인스턴스 초기화
        firestore = FirebaseFirestore.getInstance()

        val searchBestRVAdapter = RecyclerViewAdapter()
        binding.searchBestRv.adapter = searchBestRVAdapter
        binding.searchBestRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        // User 클래스 ArrayList 생성성
        var User: ArrayList<User> = arrayListOf()

        init {  // User의 문서를 불러온 뒤 User으로 변환해 ArrayList에 담음
            firestore?.collection("User")
                ?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                    // ArrayList 비워줌
                    User.clear()

                    for (snapshot in querySnapshot!!.documents) {
                        var item = snapshot.toObject(User()::class.java)
                        User.add(item!!)
                    }
                    notifyDataSetChanged()
                }
        }

        // xml파일을 inflate하여 ViewHolder를 생성
        override fun onCreateViewHolder (viewGroup: ViewGroup, viewType: Int) : ViewHolder{
            var binding: ItemSearchAccountBinding =
                ItemSearchAccountBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

            return ViewHolder(binding)
        }

        // onCreateViewHolder에서 만든 view와 실제 데이터를 연결
        inner class ViewHolder(val binding: ItemSearchAccountBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User) {
                binding.itemSearchAccountUserProfileIv.setImageResource(user.profileImg!!)
                binding.itemSearchAccountUserIDTv.text = user.name
                binding.itemSearchAccountUsernameTv.text = user.realname
//                binding.itemSearchAccountUserProfileIv.setImageResource(user.profileImg!!)
//                binding.itemSearchAccountUserIDTv.text = user.name
//                binding.itemSearchAccountUsernameTv.text = user.realname
            }
        }

        // 리사이클러뷰의 아이템 총 개수 반환
        override fun getItemCount(): Int {
            return User.size
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBestBinding.inflate(inflater, container, false)

//        // 파이어스토어 인스턴스 초기화
//        firestore = FirebaseFirestore.getInstance()
//
//        val searchBestRVAdapter = RecyclerViewAdapter()
//        binding.searchBestRv.adapter = searchBestRVAdapter
//        binding.searchBestRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}
