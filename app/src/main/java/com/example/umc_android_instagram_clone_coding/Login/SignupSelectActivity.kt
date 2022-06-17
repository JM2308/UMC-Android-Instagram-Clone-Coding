package com.example.umc_android_instagram_clone_coding.Login

import android.R.attr.button
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivitySignupSelectBinding
import com.google.android.material.tabs.TabLayout


class SignupSelectActivity: AppCompatActivity() {

    lateinit var binding : ActivitySignupSelectBinding
    lateinit var tab1 : SignupSelectNumberFragment
    lateinit var tab2 : SignupSelectEmailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupSelectBinding.inflate(layoutInflater)

        tab1 = SignupSelectNumberFragment()
        tab2 = SignupSelectEmailFragment()

        supportFragmentManager.beginTransaction().add(R.id.signup_fl, tab1).commit()

        binding.signupSelectTb.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> {
                        var selectedFragment: Fragment? = null
                        selectedFragment = tab1
                        selectedFragment?.let {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.signup_fl, it).commit()
                        }
                    }
                    1 -> {
                        var selectedFragment: Fragment? = null
                        selectedFragment = tab2
                        selectedFragment?.let {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.signup_fl, it).commit()
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

        binding.selectNextBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        setContentView(binding.root)
    }

}