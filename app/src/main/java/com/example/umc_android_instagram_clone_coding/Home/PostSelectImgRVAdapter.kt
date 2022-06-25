package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.PostSelectImg
import com.example.umc_android_instagram_clone_coding.databinding.ItemPostImgSelectBinding

class PostSelectImgRVAdapter(private var imgList: ArrayList<PostSelectImg>) : RecyclerView.Adapter<PostSelectImgRVAdapter.ViewHolder>() {


    interface ItemClickListener {
        fun getClickItem(img: PostSelectImg, position: Int)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var mItemClickListener: ItemClickListener

    fun setMyItemClickListener(itemClickListener: ItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemPostImgSelectBinding = ItemPostImgSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])

        holder.itemView.setOnClickListener {
            // val intent = Intent(holder.itemView?.context, PostSelectImgActivity::class.java)
            // intent.putExtra("position", position)
            mItemClickListener.getClickItem(imgList[position], position)
            Log.d("ItemClickCheck", "position = $position")

            // imgList[position].img!!
            // ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = imgList.size

    inner class ViewHolder(val binding: ItemPostImgSelectBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (img: PostSelectImg) {
            binding.postImg.setImageResource(img.img!!)
        }
    }

    fun checkItemPosition(position: Int): Int {
        return position
    }

}