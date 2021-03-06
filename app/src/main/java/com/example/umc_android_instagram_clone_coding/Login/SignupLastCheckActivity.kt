package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupLastCheckBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupLastCheckActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupLastCheckBinding

    private var db = Firebase.firestore
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupLastCheckBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()

        val number = intent.getStringExtra("number")
        val email = intent.getStringExtra("email")
        val name = intent.getStringExtra("name")
        val pwd = intent.getStringExtra("pwd")

        binding.signupLastCheckTv.text = "${name}님으로\n가입하시겠어요?"

        binding.signupCheckSignupBtn.setOnClickListener {
            if (pwd != null) {
                Log.d("SignupActivityData", pwd)
                signup(number, email, name, pwd)
            }

            finishAffinity()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        setContentView(binding.root)
    }

    private fun signup(number: String?, email: String?, name: String?, pwd: String) {
        if (number != null) {
            Log.d("SignupActivityData", "number")
        }
        else if (email != null) {
            auth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener { task ->
                    // 회원가입이 성공했다면
                    if (task.isSuccessful) {
                        // user 생성
                        val user = auth.currentUser
                        Log.d("DataCheck", "Signup Success")

                        // 초기 데이터 초기화
                        saveInitialData(name, pwd)
                    } else {
                        Log.d("DataCheck", "Initial Data Save Failed")
                    }
                }
                .addOnFailureListener { e ->
                    Log.w("DataCheck", "Initial Data Save Failed", e)
                }
        }
    }

    private fun saveInitialData(name: String?, pwd: String?) {
        var userInfo = User()
        userInfo.uid = auth?.uid
        userInfo.email = auth?.currentUser?.email
        userInfo.name = name
        userInfo.realname = null
        userInfo.pwd = pwd
        userInfo.profileImg = 0
        userInfo.follower = null
        userInfo.following = null
        userInfo.followReceive = null
        userInfo.followSend = null
        userInfo.post = null
        userInfo.story = null

        db.collection("User")
            .add(userInfo)
            .addOnSuccessListener { documentReference ->
                Log.d("DataCheck", "Initial Data Save Success")
            }
            .addOnFailureListener { e ->
                Log.w("DataCheck", "Initial Data Save Failed", e)
            }
    }
}