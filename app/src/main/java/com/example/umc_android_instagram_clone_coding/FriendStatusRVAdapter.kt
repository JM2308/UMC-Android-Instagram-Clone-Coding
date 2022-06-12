package com.example.umc_android_instagram_clone_coding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.databinding.ItemStatusBinding

class FriendStatusRVAdapter(private val statusList: ArrayList<FriendStatusData>) : RecyclerView.Adapter<FriendStatusRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendStatusRVAdapter.ViewHolder {
        val binding: ItemStatusBinding = ItemStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendStatusRVAdapter.ViewHolder, position: Int) {
        holder.bind(statusList[position])
    }

    override fun getItemCount(): Int = statusList.size

    inner class ViewHolder(val binding: ItemStatusBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(status: FriendStatusData) {
            binding.homeStatusProfile.setImageResource(status.profileImg!!)
            binding.homeStatusId.text = status.id
        }
    }
}