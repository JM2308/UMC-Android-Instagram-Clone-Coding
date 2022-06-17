package com.example.umc_android_instagram_clone_coding.Info

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_android_instagram_clone_coding.LoginActivity
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoMenuBinding
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class InfoMenuFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentInfoMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.infoMenuLogout.setOnClickListener {
            val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
            val accessToken: AccessToken? = AccessToken.getCurrentAccessToken()

            if(user!=null){
                val isLoggedIn:Boolean = accessToken != null && !accessToken.isExpired
                if(isLoggedIn){
                    FirebaseAuth.getInstance().signOut()
                    LoginManager.getInstance().logOut()
                }
                startActivity(Intent(activity, LoginActivity::class.java))
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}