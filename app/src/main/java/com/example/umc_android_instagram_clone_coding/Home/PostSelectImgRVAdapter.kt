package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.PostSelectImg
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ItemPostImgSelectBinding

class PostSelectImgRVAdapter(private var imgList: ArrayList<PostSelectImg>) : RecyclerView.Adapter<PostSelectImgRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemPostImgSelectBinding = ItemPostImgSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }

    override fun getItemCount(): Int = imgList.size

    inner class ViewHolder(val binding: ItemPostImgSelectBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (img: PostSelectImg) {
            binding.postImg.setImageResource(img.img!!)

            binding.postImg.setOnClickListener {
                Intent(context, PostSelectImgActivity::class.java).apply {
                    putExtra("selectImg", position)

                }
            }
        }
    }
}