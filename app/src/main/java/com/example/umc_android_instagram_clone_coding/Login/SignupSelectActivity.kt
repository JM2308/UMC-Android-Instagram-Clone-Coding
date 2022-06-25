package com.example.umc_android_instagram_clone_coding.Login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupSelectBinding
import com.google.android.material.tabs.TabLayout


class SignupSelectActivity: AppCompatActivity() {

    lateinit var binding : ActivitySignupSelectBinding
    var tabFlag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupSelectBinding.inflate(layoutInflater)

        setTabSelectedListener()

        binding.signupNumberText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.isNotEmpty() && tabFlag == 0) {
                    binding.selectNextBtn.isClickable = true;
                    binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_blue);
                    binding.signupNumberCancel.isVisible = true;
                } else {
                    binding.selectNextBtn.isClickable = false;
                    binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
                    binding.signupNumberCancel.isVisible = false;
                }
            }
        })

        binding.signupEmailText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.isNotEmpty() && tabFlag == 1) {
                    binding.selectNextBtn.isClickable = true;
                    binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_blue);
                    binding.signupEmailCancel.isVisible = true;
                } else {
                    binding.selectNextBtn.isClickable = false;
                    binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
                    binding.signupEmailCancel.isVisible = false;
                }
            }
        })

        binding.signupNumberCancel.setOnClickListener {
            binding.signupNumberText.setText("")
        }

        binding.signupEmailCancel.setOnClickListener {
            binding.signupEmailText.setText("")
        }

        binding.selectNextBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            sendSignupData(intent)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    private fun setTabSelectedListener() {
        binding.signupSelectTb.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> {
                        binding.signupNumberFl.visibility = View.VISIBLE
                        binding.signupEmailFl.visibility = View.GONE
                        tabFlag = 0

                        if (binding.signupNumberText.length() != 0) {
                            binding.selectNextBtn.isClickable = true;
                            binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_blue);
                        } else {
                            binding.selectNextBtn.isClickable = false;
                            binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
                        }
                    }
                    1 -> {
                        binding.signupNumberFl.visibility = View.GONE
                        binding.signupEmailFl.visibility = View.VISIBLE
                        tabFlag = 1

                        if (binding.signupEmailText.length() != 0) {
                            binding.selectNextBtn.isClickable = true;
                            binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_blue);
                        } else {
                            binding.selectNextBtn.isClickable = false;
                            binding.selectNextBtn.setBackgroundResource(R.drawable.round_border_unclick_blue);
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("SignupSelect", "Unselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("SignupSelect", "Reselected")
            }
        })
    }

    private fun sendSignupData(intent : Intent) {
        when (tabFlag) {
            0 -> intent.putExtra("number", binding.signupNumberText.text.toString())
            else -> intent.putExtra("email", binding.signupEmailText.text.toString())
        }
    }
}