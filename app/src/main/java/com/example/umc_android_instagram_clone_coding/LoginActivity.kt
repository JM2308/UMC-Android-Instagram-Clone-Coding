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

        binding.loginFacebookBt.setOnClickListener { // button clickListener 설정
            facebookLogin()
        }
    }

    private fun facebookLogin(){
        LoginManager.getInstance() // LoginManager instance 얻어오기
            .logInWithReadPermissions(this,
                Arrays.asList("public_profile","email")) // 권한 설정하기(사용자의 어떤 항목을 조회할 수 있는지)

        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult) {  // 로그인 성공시

                    handleFacebookAccessToken(result?.accessToken)
                    // 파이어베이스로 로그인 데이터를 넘겨줌

                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish() // 로그인에 성공하면 LoginActivity 종료
                }

                override fun onCancel() { // 로그인 취소 시
                }

                override fun onError(error: FacebookException) { // 로그인 에러 시
                }
            })
    }

    private fun handleFacebookAccessToken(token: AccessToken?) {

        Log.d(TAG, "handleFacebookAccessToken:$token")

        var credential = FacebookAuthProvider.getCredential(token?.token!!)
        val auth = FirebaseAuth.getInstance()

        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "환영합니다!", Toast.LENGTH_SHORT).show()
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
