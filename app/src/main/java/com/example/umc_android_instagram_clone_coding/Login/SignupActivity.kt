package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        
        setTextChangedListener()
        setClickListener()

        setContentView(binding.root)
    }

    private fun setTextChangedListener() {
        binding.signupNameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.isNotEmpty() && binding.signupPwdText.text.length >= 6) {
                    binding.signupNumberConnect.isClickable = true;
                    binding.signupNumberConnect.setBackgroundResource(R.drawable.round_border_blue);
                    binding.signupNumberDisconnect.isClickable = true;
                    binding.signupNumberDisconnect.setTextColor(Color.parseColor("#0099FF"))
                    binding.signupNameCancel.isVisible = true
                } else if (editable.isNotEmpty()) {
                    binding.signupNameCancel.isVisible = true
                } else {
                    binding.signupNumberConnect.isClickable = false;
                    binding.signupNumberConnect.setBackgroundResource(R.drawable.round_border_unclick_blue);
                    binding.signupNumberDisconnect.isClickable = false;
                    binding.signupNumberDisconnect.setTextColor(Color.parseColor("#B2DFFC"))
                    binding.signupNameCancel.isVisible = false;
                }
            }
        })

        binding.signupPwdText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (binding.signupNameText.text.isNotEmpty() && binding.signupPwdText.text.length >= 6) {
                    binding.signupNumberConnect.isClickable = true;
                    binding.signupNumberConnect.setBackgroundResource(R.drawable.round_border_blue);
                    binding.signupNumberDisconnect.isClickable = true;
                    binding.signupNumberDisconnect.setTextColor(Color.parseColor("#0099FF"))
                } else {
                    binding.signupNumberConnect.isClickable = false;
                    binding.signupNumberConnect.setBackgroundResource(R.drawable.round_border_unclick_blue);
                    binding.signupNumberDisconnect.isClickable = false;
                    binding.signupNumberDisconnect.setTextColor(Color.parseColor("#B2DFFC"))
                }
            }
        })
    }

    private fun setClickListener() {
        binding.signupNameCancel.setOnClickListener {
            binding.signupNameText.setText("")
        }

        binding.signupNumberConnect.setOnClickListener {
            val number = intent.getStringExtra("number")
            val email = intent.getStringExtra("email")
            val name = binding.signupNameText.text.toString()
            val pwd = binding.signupPwdText.text.toString()

            val intent = Intent(this, SignupBirthdayActivity::class.java)
            intent.putExtra("number", number)
            intent.putExtra("email", email)
            intent.putExtra("name", name)
            intent.putExtra("pwd", pwd)

            Log.d("SignupActivityData", "number = $number email = $email name = $name")

            startActivity(intent)
        }

        binding.signupNumberDisconnect.setOnClickListener {
            startActivity(Intent(this, SignupBirthdayActivity::class.java))
        }
    }
}