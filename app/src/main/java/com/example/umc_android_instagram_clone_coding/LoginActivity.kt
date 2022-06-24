package com.example.umc_android_instagram_clone_coding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.example.umc_android_instagram_clone_coding.Login.SignupSelectActivity
import com.example.umc_android_instagram_clone_coding.databinding.ActivityLoginBinding
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser



import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var callbackManager: CallbackManager
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        callbackManager = CallbackManager.Factory.create()
        auth = FirebaseAuth.getInstance() // Authentication 가져오기
        binding.loginFacebookLoginBt.setOnClickListener { // button clickListener 설정
            facebookLogin()
        }

        binding.loginLoginBt.setOnClickListener{
            val id = binding.loginIdEt.text.toString()
            val pwd = binding.loginPwdEt.text.toString()

            if (id.isBlank() || pwd.isBlank()) {
                Toast.makeText(this, "아이디/패스워드 입력해주세요", Toast.LENGTH_LONG).show()
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(id, pwd)
                    .addOnCompleteListener{ task -> // 파이어베이스에 등록된 유저인 경우
                        task.addOnSuccessListener {
                            binding.loginIdEt.text = null
                            binding.loginPwdEt.text = null
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                        task.addOnFailureListener {
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
        binding.loginSignupTv.setOnClickListener { // 회원가입 클릭 시
            startActivity(Intent(this, SignupSelectActivity::class.java))
            finish()
        }
    }

    private fun facebookLogin(){
        LoginManager.getInstance() // LoginManager instance 얻어오기
            .logInWithReadPermissions(this,
                Arrays.asList("public_profile", "email")) // 권한 설정하기(사용자의 어떤 항목을 조회할 수 있는지)
        Log.d("confirm","1")
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult) {  // 로그인 성공시

                    handleFacebookAccessToken(result?.accessToken)
                    // 파이어베이스로 로그인 데이터를 넘겨줌
                    Log.d("confirm","2")
                    startActivity(Intent(applicationContext, SignupSelectActivity::class.java))
                    finish() // 로그인에 성공하면 LoginActivity 종료

                }

                override fun onCancel() { // 로그인 취소 시
                    Log.d("confirm","3")
                }

                override fun onError(error: FacebookException) { // 로그인 에러 시
                    Log.d("confirm","4")
                }
            })
    }

    private fun handleFacebookAccessToken(token: AccessToken?) {

        Log.d(TAG, "handleFacebookAccessToken:$token")

        var credential = FacebookAuthProvider.getCredential(token?.token!!) // 페이스북 로그인 토큰 받아오기

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

    override fun onStart() {
        super.onStart()
        moveMainPage(auth.currentUser)
    }

    private fun moveMainPage(user: FirebaseUser?){ // 로그인 세션 유지
        if( user!= null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    companion object {
        const val TAG: String = "facebookLogin"
    }
}
