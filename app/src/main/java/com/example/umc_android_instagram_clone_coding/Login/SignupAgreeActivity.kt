package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupAgreeBinding

class SignupAgreeActivity: AppCompatActivity() {

    lateinit var binding : ActivitySignupAgreeBinding
    var checkAllFlag = 0
    var checkFlag1 = 0
    var checkFlag2 = 0
    var checkFlag3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupAgreeBinding.inflate(layoutInflater)

        binding.signupAgreeAllBtn.setOnClickListener {
            if (checkAllFlag == 0) {
                binding.signupAgreeAllBtn.setBackgroundResource(R.drawable.signup_check)
                binding.signupAgreeServiceBtn.setBackgroundResource(R.drawable.signup_check)
                binding.signupAgreeDataBtn.setBackgroundResource(R.drawable.signup_check)
                binding.signupAgreeGpsBtn.setBackgroundResource(R.drawable.signup_check)
                checkAllFlag = 1
                checkFlag1 = 1
                checkFlag2 = 1
                checkFlag3 = 1
                binding.signupAgreeNextBtn.isClickable = true;
                binding.signupAgreeNextBtn.setBackgroundResource(R.drawable.round_border_blue);
            } else if (checkAllFlag == 1) {
                binding.signupAgreeAllBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                binding.signupAgreeServiceBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                binding.signupAgreeDataBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                binding.signupAgreeGpsBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                checkAllFlag = 0
                checkFlag1 = 0
                checkFlag2 = 0
                checkFlag3 = 0
                binding.signupAgreeNextBtn.isClickable = false;
                binding.signupAgreeNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
            }
        }

        binding.signupAgreeServiceBtn.setOnClickListener {
            if (checkFlag1 == 0) {
                binding.signupAgreeServiceBtn.setBackgroundResource(R.drawable.signup_check)
                checkFlag1 = 1
                allCheck()
            }
            else if (checkFlag1 == 1) {
                binding.signupAgreeServiceBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                checkFlag1 = 0
                allCheck()
            }
        }

        binding.signupAgreeDataBtn.setOnClickListener {
            if (checkFlag2 == 0) {
                binding.signupAgreeDataBtn.setBackgroundResource(R.drawable.signup_check)
                checkFlag2 = 1
                allCheck()
            }
            else if (checkFlag2 == 1) {
                binding.signupAgreeDataBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                checkFlag2 = 0
                allCheck()
            }
        }

        binding.signupAgreeGpsBtn.setOnClickListener {
            if (checkFlag3 == 0) {
                binding.signupAgreeGpsBtn.setBackgroundResource(R.drawable.signup_check)
                checkFlag3 = 1
                allCheck()
            }
            else if (checkFlag3 == 1) {
                binding.signupAgreeGpsBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
                checkFlag3 = 0
                allCheck()
            }
        }

        binding.signupAgreeNextBtn.setOnClickListener {
            startActivity(Intent(this, SignupLastCheckActivity::class.java))
        }

        setContentView(binding.root)
    }

    private fun allCheck() {
        if (checkFlag1 == 1 && checkFlag2 == 1 && checkFlag3 == 1) {
            binding.signupAgreeAllBtn.setBackgroundResource(R.drawable.signup_check)
            checkAllFlag = 1
            binding.signupAgreeNextBtn.isClickable = true;
            binding.signupAgreeNextBtn.setBackgroundResource(R.drawable.round_border_blue);
        } else {
            binding.signupAgreeAllBtn.setBackgroundResource(R.drawable.signup_agree_uncheck)
            checkAllFlag = 0
            binding.signupAgreeNextBtn.isClickable = false;
            binding.signupAgreeNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
        }
    }
}