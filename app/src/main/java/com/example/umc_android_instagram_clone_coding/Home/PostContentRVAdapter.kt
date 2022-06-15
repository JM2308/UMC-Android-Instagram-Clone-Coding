package com.example.umc_android_instagram_clone_coding.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.PostContentItem
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ItemPostContentBinding

class PostContentRVAdapter(private var postContentList: ArrayList<PostContentItem>) : RecyclerView.Adapter<PostContentRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int = postContentList.size

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemPostContentBinding =
            ItemPostContentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postContentList[position])
    }

    inner class ViewHolder(val binding: ItemPostContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(postContent: PostContentItem) {
            binding.itemPostContentProfile.setImageResource(postContent.profile!!)
            binding.itemPostContentId.text = postContent.id
            binding.itemPostContentImg.setImageResource(postContent.img!!)
            binding.itemPostContentLikeNum.text = "좋아요 " + postContent.like + "개"
            binding.itemPostContentContent.text = postContent.content
            binding.itemPostContentCommentNum.text = "댓글 " + postContent.comment + "개 모두 보기"
            binding.itemPostContentDate.text = postContent.date

            if (postContent.storyStatus == 1)
                binding.itemPostContentStory.setImageResource(R.drawable.story_border)
        }
    }
}