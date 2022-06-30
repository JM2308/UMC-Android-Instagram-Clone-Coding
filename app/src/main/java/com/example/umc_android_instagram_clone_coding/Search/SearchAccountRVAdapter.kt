package com.example.umc_android_instagram_clone_coding.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.Account
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.databinding.ItemSearchAccountBinding
import com.google.firebase.firestore.FirebaseFirestore


class SearchAccountRVAdapter(private val accountList: ArrayList<User>) :  RecyclerView.Adapter<SearchAccountRVAdapter.ViewHolder>() {

    // account 리사뷰 아이템 클릭
    interface MyItemClickListener{
        fun onItemClick(user:User)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemclickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val binding: ItemSearchAccountBinding =
            ItemSearchAccountBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(accountList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(accountList[position])} //아이템 클릭이벤트 (계정 데이터를 인자값으로)accountList[position]
    }

    override fun getItemCount(): Int = accountList.size

    inner class ViewHolder(val binding: ItemSearchAccountBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.itemSearchAccountUserProfileIv.setImageResource(user.profileImg!!)
            binding.itemSearchAccountUserIDTv.text = user.name
            binding.itemSearchAccountUsernameTv.text = user.realname
        }
    }
}