package com.example.umc_android_instagram_clone_coding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.example.umc_android_instagram_clone_coding.databinding.ActivityLoginBinding
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth


import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var callbackManager: CallbackManager
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        callbackManager = CallbackManager.Factory.create()

        binding.loginFacebookBt.setOnClickListener {
            facebookLogin()
        }
    }

    private fun facebookLogin(){
        LoginManager.getInstance()
            .logInWithReadPermissions(this, Arrays.asList("public_profile","email"))

        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult) {
                    // 로그인 성공시
                    handleFacebookAccessToken(result?.accessToken)
                    // 파이어베이스로 로그인 데이터를 넘겨줌
                }

                override fun onCancel() {

                }

                override fun onError(error: FacebookException) {

                }
            })
    }

    private fun handleFacebookAccessToken(token: AccessToken?) {

        Log.d(TAG, "handleFacebookAccessToken:$token")

        var credential = FacebookAuthProvider.getCredential(token?.token!!)
        val auth = FirebaseAuth.getInstance()

        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }

    companion object {
        const val TAG: String = "facebookLogin"
    }
}
