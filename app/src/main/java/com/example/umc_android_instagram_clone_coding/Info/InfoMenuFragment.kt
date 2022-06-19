package com.example.umc_android_instagram_clone_coding.Info

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_android_instagram_clone_coding.LoginActivity1
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
        binding.infoMenuLogout.setOnClickListener {  // 로그아웃 프로세스
            val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
            val accessToken: AccessToken? = AccessToken.getCurrentAccessToken()

            if(user!=null){
                val isLoggedIn:Boolean = accessToken != null && !accessToken.isExpired
                if (isLoggedIn){
                    FirebaseAuth.getInstance().signOut()
                    LoginManager.getInstance().logOut()
                }
                startActivity(Intent(activity, LoginActivity1::class.java)) // 로그아웃 시 로그인 화면 이동
                activity?.finish() // 로그아웃시 스택에 있는 메인 액티비티 종료
            }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}