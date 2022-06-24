package com.example.umc_android_instagram_clone_coding.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.PostSelectImg
import com.example.umc_android_instagram_clone_coding.Info.InfoPostRVAdapter
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivityPostSelectImgBinding

class PostSelectImgActivity: AppCompatActivity() {
    lateinit var binding: ActivityPostSelectImgBinding
    private var imgDatas = ArrayList<PostSelectImg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostSelectImgBinding.inflate(layoutInflater)

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        imgDatas.apply {
            add(PostSelectImg(R.drawable.img_shop1))
            add(PostSelectImg(R.drawable.img_shop2))
            add(PostSelectImg(R.drawable.img_shop3))
            add(PostSelectImg(R.drawable.img_shop4))
            add(PostSelectImg(R.drawable.img_shop5))
            add(PostSelectImg(R.drawable.img_shop6))
            add(PostSelectImg(R.drawable.img_shop7))
            add(PostSelectImg(R.drawable.img_shop3))
        }

        val postSelectAdapter = PostSelectImgRVAdapter(imgDatas) // 더미데이터랑 Adapter 연결
        binding.postSelectImgRv.adapter = postSelectAdapter // 리사이클러뷰에 어댑터를 연결
        binding.postSelectImgRv.layoutManager = GridLayoutManager(this,3)

        setContentView(binding.root)
    }
}