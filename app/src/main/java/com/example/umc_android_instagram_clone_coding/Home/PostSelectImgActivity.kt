package com.example.umc_android_instagram_clone_coding.Home

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.PostSelectImg
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivityPostSelectImgBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PostSelectImgActivity: AppCompatActivity() {
    lateinit var binding: ActivityPostSelectImgBinding
    private var imgDatas = ArrayList<PostSelectImg>()
    private var selectPosition: Int? = null
    val gallery = 0
    var imgUri: Uri? = null
    private var selectImg = String

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

        val postSelectAdapter = PostSelectImgRVAdapter(imgDatas)
        binding.postSelectImgRv.adapter = postSelectAdapter

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
            }
        })

        binding.postSelectImgRv.layoutManager = GridLayoutManager(this,4)

        binding.postImgCancelBtn.setOnClickListener {
            finish()
        }

        binding.postSelectNextBtn.setOnClickListener {
            val intent = Intent(this, PostWriteActivity::class.java)
            intent.putExtra("img", imgUri.toString())
            startActivity(intent)
        }

        binding.selectImgMultiBtn.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, gallery)
        }

        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == gallery) {
            if (resultCode == RESULT_OK) {
                imgUri = data?.data
                try {
                    binding.postSelectImg.setImageURI(imgUri)
                } catch (e:Exception) {
                    Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}