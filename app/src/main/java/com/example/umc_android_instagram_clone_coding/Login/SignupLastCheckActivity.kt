package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupLastCheckBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class SignupLastCheckActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupLastCheckBinding

    private lateinit var auth : FirebaseAuth
    private lateinit var firestore : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupLastCheckBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        binding.signupCheckSignupBtn.setOnClickListener {
            val number = intent.getStringExtra("number")
            val email = intent.getStringExtra("email")
            val name = intent.getStringExtra("name")
            val pwd = intent.getStringExtra("pwd")

            Log.d("SignupActivityData", "pwd = $pwd")

            if (pwd != null) {
                Log.d("SignupActivityData", pwd)
                signup(number, email, name, pwd)
            }

            // finishAffinity()
            // startActivity(Intent(this, MainActivity::class.java))
        }

        setContentView(binding.root)
    }

    private fun signup(number: String?, email: String?, name: String?, pwd: String) {
        if (number != null) {
            Log.d("SignupActivityData", "number")
        }
        else if (email != null) {
            val db = Firebase.firestore

            auth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener { task ->
                    // 회원가입이 성공했다면
                    if (task.isSuccessful) {
                        // user 생성
                        val user = auth.currentUser
                        Log.d("SignupActivityData", "email = $email")
                        Log.d("SignupActivityData", "Success")

                        var userInfo = User()
                        userInfo.uid = auth?.uid
                        userInfo.email = auth?.currentUser?.email
                        userInfo.name = name
                        userInfo.pwd = pwd

                        Log.d("SignupActivityData", "uid = " + userInfo.uid + " email = " + userInfo.email)

                        firestore?.collection("User")?.document(auth?.uid.toString())?.set(userInfo)
                            ?.addOnSuccessListener {
                                Log.d("SignupActivityData", "Save Success")
                            }?.addOnFailureListener {
                                Log.d("SignupActivityData", "Save Failed")
                            }
                    } else {
                        Log.d("SignupActivityData", "Failed 1")
                        Log.d("SignupActivityData", "email = $email")
                    }
                }
                .addOnFailureListener {
                    Log.d("SignupActivityData", "Failed 2")
                    Log.d("SignupActivityData", "email = $email")
                }
        }
    }
}