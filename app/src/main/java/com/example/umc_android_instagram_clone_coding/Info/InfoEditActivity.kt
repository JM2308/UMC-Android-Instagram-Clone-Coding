package com.example.umc_android_instagram_clone_coding.Info

import android.app.Activity
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityInfoEditBinding
import com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest
import kotlin.math.log

class InfoEditActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInfoEditBinding.inflate(layoutInflater)
    }

    private var firestore: FirebaseFirestore? = null
    private var uid: String? = null
    private var storage : FirebaseStorage? = null
    var uriPhoto : Uri? = null
    var pickImageFromAlbum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        uid = FirebaseAuth.getInstance().currentUser?.uid  // 유저 고유 아이디 초기화
        firestore = FirebaseFirestore.getInstance()  // 파이어베이스 파이어스토어 db 가져오기
        storage = FirebaseStorage.getInstance() // 파이어베이스 스토리지 불러오기

        binding.infoEditChangeProfileTv.setOnClickListener {  // 프로필 사진 변경
            var photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, pickImageFromAlbum)
        }


        val documentId: String? = intent.getStringExtra("documentId") // 사용자 고유 문서 id
        val db = firestore?.collection("User")
        val setting = mutableMapOf<String, Any>()

        db?.whereEqualTo("uid", uid) // uid가 현재 로그인한 uid랑 같은 문서 찾기
            ?.get()
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    for (dc in it.result!!.documents) {
                        val user = dc.toObject(User::class.java)
                        binding.infoEditNameEt.hint = user?.name
                    }
                }
            }

        binding.infoEditCloseIv.setOnClickListener {
            finish()
        }
        binding.infoEditCheckIv.setOnClickListener {
            var name: String = binding.infoEditNameEt.text.toString()
            var realName: String = binding.infoEditIdEt.text.toString()
            var intro: String = binding.infoEditIntroEt.text.toString()
            var link: String = binding.infoEditLinkEt.text.toString()

            if (name != "") // 닉네임이 빈칸이면 안바껴 맨~
                setting["name"] = name
            setting["realname"] = realName
            setting["introduce"] = intro
            setting["link"] = link

            db?.document(documentId!!)?.update(setting)?.addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("infoUpdate", "success")
                }
                Log.d("infoupdate","$name $realName $intro $link")
                Log.d("infoupdate","$setting")

            }
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }


        // Create a storage reference from our app
        storage = FirebaseStorage.getInstance()

        binding.infoEditChangeProfileTv.setOnClickListener {
            var photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, pickImageFromAlbum)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickImageFromAlbum) {
            if (resultCode == Activity.RESULT_OK) {
                uriPhoto = data?.data
                binding.infoEditProfileImageIv.setImageURI(uriPhoto)
                Log.d("image", uriPhoto.toString())
                var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                var imgFileName = uid!!
                var storageRef = storage?.reference?.child("images")?.child(imgFileName)
                storageRef?.putFile(uriPhoto!!)?.addOnSuccessListener {
                    Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}