package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.HomeStoryData
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ItemStoryBinding

class HomeStoryRVAdapter(private var homeStoryList: ArrayList<HomeStoryData>) : RecyclerView.Adapter<HomeStoryRVAdapter.ViewHolder>() {

    //아이템 클릭
    interface MyItemClickListener{
        fun onItemClick()
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun getItemCount(): Int = homeStoryList.size

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemStoryBinding = ItemStoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(homeStoryList[position])
//        holder.itemView.setOnClickListener { mItemClickListener.onItemClick() }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, StoryActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        } //아이템 클릭 함수 호출
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