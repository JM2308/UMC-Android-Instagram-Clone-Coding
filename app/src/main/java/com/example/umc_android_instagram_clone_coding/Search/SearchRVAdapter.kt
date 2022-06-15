package com.example.umc_android_instagram_clone_coding.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.databinding.ItemSearchBinding

class SearchRVAdapter(private val searchList: ArrayList<Search>): RecyclerView.Adapter<SearchRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemSearchBinding =
            ItemSearchBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int = searchList.size

    inner class ViewHolder(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(search: Search) {
            binding.itemSearchImgIv.setImageResource(search.searchImg!!)
        }
    }
}