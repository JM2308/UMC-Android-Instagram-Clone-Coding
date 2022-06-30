package com.example.umc_android_instagram_clone_coding.Reels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.Reels
import com.example.umc_android_instagram_clone_coding.databinding.ItemReelsBinding

class ReelsRVAdapter(private val reelsList: ArrayList<Reels>): RecyclerView.Adapter<ReelsRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemReelsBinding = ItemReelsBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reelsList[position])
    }

    override fun getItemCount(): Int = reelsList.size

    inner class ViewHolder(val binding: ItemReelsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(reels: Reels) {
            binding.itemReelsUserIDTv.text = reels.userId
            binding.itemReelsTitle.text = reels.title
            binding.itemReelsUserProfileIv.setImageResource(reels.profileImg!!)
            binding.itemReelsHeartSizeTv.text = reels.likes
            binding.itemReelsChatSizeTv.text = reels.chat
        }
    }
}