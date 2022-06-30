package com.example.umc_android_instagram_clone_coding.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBestBinding
import com.google.firebase.firestore.FirebaseFirestore

class SearchBestActivity: AppCompatActivity() {

    var firestore : FirebaseFirestore? = null

    private val binding by lazy {
        FragmentSearchBestBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 파이어스토어 인스턴스 초기화
        firestore = FirebaseFirestore.getInstance()

        val searchBestRVAdapter = RecyclerViewAdapter()
        binding.searchBestRv.adapter = searchBestRVAdapter
        binding.searchBestRv.layoutManager = LinearLayoutManager(this)
    }
    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        // User 클래스 ArrayList 생성성
        var user : ArrayList<User> = arrayListOf()

        init {  // telephoneBook의 문서를 불러온 뒤 Person으로 변환해 ArrayList에 담음
            firestore?.collection("User")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                // ArrayList 비워줌
                user.clear()

                for (snapshot in querySnapshot!!.documents) {
                    var item = snapshot.toObject(User::class.java)
                    user.add(item!!)
                }
                notifyDataSetChanged()
            }
        }

        // xml파일을 inflate하여 ViewHolder를 생성
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_account, parent, false)
            return ViewHolder(view)
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        }

        // onCreateViewHolder에서 만든 view와 실제 데이터를 연결
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewHolder = (holder as ViewHolder).itemView

//            viewHolder.item.text = user[position].name
//            viewHolder.iem.text = user[position].realname
        }

        // 리사이클러뷰의 아이템 총 개수 반환
        override fun getItemCount(): Int {
            return user.size
        }
    }
}