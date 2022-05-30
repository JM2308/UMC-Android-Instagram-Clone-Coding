package com.example.umc_android_instagram_clone_coding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.databinding.ItemStoryBinding

class HomeStoryRVAdapter(private var homeStoryList: ArrayList<HomeStoryData>) : RecyclerView.Adapter<HomeStoryRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int = homeStoryList.size

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): HomeStoryRVAdapter.ViewHolder {
        val binding: ItemStoryBinding = ItemStoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeStoryRVAdapter.ViewHolder, position: Int) {
        holder.bind(homeStoryList[position])
    }

    inner class ViewHolder(val binding: ItemStoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(story: HomeStoryData) {
            binding.itemHomeStoryId.text = story.id
            binding.itemStoryProfile.setImageResource(story.coverImg!!)

            if (story.status == 0)
                binding.itemStoryAdd.setImageResource(R.drawable.add_story)
            else if (story.status == 1)
                binding.itemStoryBorder.setImageResource(R.drawable.story_border)
            else if (story.status == -1)
                binding.itemStoryBorder.setImageResource(R.drawable.check_story)
        }
    }
}