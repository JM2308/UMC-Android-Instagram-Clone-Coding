package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityPostWriteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class PostWriteActivity: AppCompatActivity() {

    lateinit var binding: ActivityPostWriteBinding

    private var db = Firebase.firestore
    var fbStorage : FirebaseStorage? = FirebaseStorage.getInstance()
    private var firestore: FirebaseFirestore? = null

    private var uid: String? = null
    var imgUri: Uri? = null
    var bitmap: Bitmap? = null
    val TAG: String = "DataSaveCheck"
    var imgFileName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostWriteBinding.inflate(layoutInflater)

        // 받은 image uri string을 uri로 변환
        imgUri = Uri.parse(intent.getStringExtra("img"))
        Log.d("DataCheck", imgUri.toString())

        // 변환시킨 uri를 통해 이미지 적용
        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imgUri)
        binding.postWriteSelectImg.setImageBitmap(bitmap)

        binding.postWriteBackBtn.setOnClickListener {
            finish()
        }

        binding.postWriteUploadBtn.setOnClickListener {
            // 데이터 저장해주는 부분
            val content = binding.postWriteContent.text

            uid = FirebaseAuth.getInstance().currentUser?.uid  // 유저 고유 아이디 초기화
            firestore = FirebaseFirestore.getInstance()  // 파이어베이스 파이어스토어 db 가져오기

            val userDB = firestore?.collection("User")
            val postDB = firestore?.collection("Post")
            lateinit var documentId: String

            Log.d("DataSaveCheck", "Uid = " + uid.toString())
            Log.d("DataSaveCheck", "Equal Uid = " + userDB?.whereEqualTo("uid", uid)?.get().toString())

            userDB?.whereEqualTo("uid", uid) // uid가 현재 로그인한 uid랑 같은 문서 찾기
                ?.get()
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        for (dc in it.result!!.documents) {
                            documentId = dc.id

                            var uidStr = uid.toString()
                            var date = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date()).toString()
                            var image = imgFileName
                            var content = binding.postWriteContent.text.toString()
                            var comment = ""

                            val post_detail: Map<String, Any> = hashMapOf(
                                "uid" to uidStr,
                                "date" to date,
                                "image" to image,
                                "content" to content,
                                "comment" to comment
                            )

                            Toast.makeText(this, "Wait...", Toast.LENGTH_SHORT).show()

                            uploadPost(post_detail)
                        }
                    }
                }
        }

        setContentView(binding.root)
    }

    private fun uploadPost(post: Map<String, Any>) {
        db.collection("Post").add(post).addOnSuccessListener {
            uploadImg(imgUri!!)
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()
            finishAffinity()
            startActivity(Intent(this, MainActivity::class.java))
        }
            .addOnFailureListener { e ->
                Log.w(TAG, "failed", e)
                Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
            }
    }
    
    private fun uploadImg(fileUri: Uri) {
        var timestamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        imgFileName = "POST_" + timestamp + "_.jpg"
        var storageRef = fbStorage?.reference?.child("posts")?.child(imgFileName)
        storageRef?.putFile(fileUri!!)?.addOnSuccessListener {
            Toast.makeText(applicationContext, "SUCCESS", Toast.LENGTH_SHORT).show()
        }
    }
}