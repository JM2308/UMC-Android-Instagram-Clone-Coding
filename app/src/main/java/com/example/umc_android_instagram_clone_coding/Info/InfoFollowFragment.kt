package com.example.umc_android_instagram_clone_coding.Info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.umc_android_instagram_clone_coding.Data.Account
import com.example.umc_android_instagram_clone_coding.Data.User
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.SearchDetailFragment
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoFollowBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

class InfoFollowFragment : Fragment() {
    lateinit var binding: FragmentInfoFollowBinding
    private var gson : Gson = Gson()

    private var firestore: FirebaseFirestore? = null
    private var uid: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoFollowBinding.inflate(inflater, container, false)

        uid = FirebaseAuth.getInstance().currentUser?.uid  // 유저 고유 아이디 초기화
        firestore = FirebaseFirestore.getInstance()  // 파이어베이스 파이어스토어 db 가져오기

        val db = firestore?.collection("User")
        val setting = mutableMapOf<String, Any>()

        var isFollow: Boolean = false //팔로우 X

        //팔로우 버튼 누르면 팔로우 신청
        if (isFollow == false) {
            binding.infoFollowFollowBtn.setOnClickListener {
                isFollow = true
                binding.infoFollowFollowBtn.visibility = View.GONE
                binding.infoFollowFollowingBtn.visibility = View.VISIBLE
            }
        }

        //한번 더 누르면 신청 취소
        binding.infoFollowFollowingBtn.setOnClickListener {
            isFollow = false
            binding.infoFollowFollowBtn.visibility = View.VISIBLE
            binding.infoFollowFollowingBtn.visibility = View.GONE
        }

        /* Fragment 전환 */
        binding.infoFollowBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(
                R.id.main_fl,
                SearchDetailFragment()
            ).commitAllowingStateLoss()
        }

//        val accountJson = arguments?.getString("account")
//        val account = gson.fromJson(accountJson, Account::class.java)
//        setInit(account)

        return binding.root
    }


    private fun setInit(account: Account) {
        binding.infoFollowUidTv.text = account.userId.toString()
        binding.infoNameTv.text = account.username.toString()
        binding.infoProfileIv.setImageResource(account.profileImg!!)
    }
}