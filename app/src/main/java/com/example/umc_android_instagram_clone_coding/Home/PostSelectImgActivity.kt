package com.example.umc_android_instagram_clone_coding.Home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.PostSelectImg
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivityPostSelectImgBinding

class PostSelectImgActivity: AppCompatActivity() {
    lateinit var binding: ActivityPostSelectImgBinding
    private var imgDatas = ArrayList<PostSelectImg>()
    private var selectPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostSelectImgBinding.inflate(layoutInflater)

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

        postSelectAdapter.setMyItemClickListener(object : PostSelectImgRVAdapter.ItemClickListener{
            override fun getClickItem(img: PostSelectImg, position: Int) {
                // 상단 ImageView에 선택한 이미지 띄우기
                binding.postSelectImg.setImageResource(img.img!!)

                // 선택 해제된 이미지 투명도 상태 원래대로
                if (selectPosition != null)
                    binding.postSelectImgRv[selectPosition!!].alpha = 1F

                // 새로 선택한 이미지 투명도 적용
                binding.postSelectImgRv[position].alpha = 0.5F
                selectPosition = position

                Log.d("ItemClickCheck", "Activity Item Click Check")
                Log.d("ItemClickCheck", "Click Img = " + binding.postSelectImgRv.get(position))
            }
        })

        binding.postSelectImgRv.layoutManager = GridLayoutManager(this,4)

        setContentView(binding.root)
    }
}