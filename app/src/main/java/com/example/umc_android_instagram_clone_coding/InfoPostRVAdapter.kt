package com.example.umc_android_instagram_clone_coding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.databinding.ItemPostBinding

class InfoPostRVAdapter(private var postItemList : ArrayList<PostItem>) : RecyclerView.Adapter<InfoPostRVAdapter.ViewHolder>(){
    override fun onCreateViewHolder(  // 뷰홀더 생성
        parent: ViewGroup,
        viewType: Int
    ): InfoPostRVAdapter.ViewHolder {
        val binding: ItemPostBinding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InfoPostRVAdapter.ViewHolder, position: Int) {  // 뷰 홀더에 데이터 바인딩 할 때 마다 호출
        holder.bind(postItemList[position])
    }

    override fun getItemCount(): Int = postItemList.size

    inner class ViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {  // 포스트(피드) 이미지 데이터가 적용될 반복되는 뷰 (뷰홀더)
        fun bind(postItem : PostItem) {
            binding.itemPostIv.setImageResource(postItem.postImg!!)
        }
    }
}