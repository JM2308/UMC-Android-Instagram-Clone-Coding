package com.example.umc_android_instagram_clone_coding.Home

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityPostWriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class PostWriteActivity: AppCompatActivity() {

    lateinit var binding: ActivityPostWriteBinding
    private var db = Firebase.firestore
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostWriteBinding.inflate(layoutInflater)

        val image = intent.getStringExtra("img")

        // binding.postWriteSelectImg.setImageResource(image)

        binding.postWriteBackBtn.setOnClickListener {
            finish()
        }

        binding.postWriteUploadBtn.setOnClickListener {
            // 데이터 저장해주는 부분
            val content = binding.postWriteContent.text
            val img = image

            val data = hashMapOf(
                "content" to content,
                "img" to img
            )

            Log.d("DataSaveCheck", data.toString())
            Log.d("DataSaveCheck", auth?.uid.toString())

            // db.collection("User").document(auth?.uid.toString()).set(data)
        }

        setContentView(binding.root)
    }
}