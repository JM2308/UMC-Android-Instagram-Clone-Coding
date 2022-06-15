package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.DMMsgListData
import com.example.umc_android_instagram_clone_coding.Data.FriendStatusData
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.ActivityHomeDmBinding

class DMActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeDmBinding
    private var statusDatas = ArrayList<FriendStatusData>()
    private var msgListDatas = ArrayList<DMMsgListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeDmBinding.inflate(layoutInflater)

        val statusAdapter = FriendStatusRVAdapter(statusDatas)
        binding.dmFriendRv.adapter = statusAdapter
        binding.dmFriendRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        statusDatas.apply {
            add(FriendStatusData(R.drawable.profile, "example1"))
            add(FriendStatusData(R.drawable.profile, "example2"))
            add(FriendStatusData(R.drawable.profile, "example3"))
            add(FriendStatusData(R.drawable.profile, "example4"))
            add(FriendStatusData(R.drawable.profile, "example5"))
            add(FriendStatusData(R.drawable.profile, "example6"))
            add(FriendStatusData(R.drawable.profile, "example7"))
            add(FriendStatusData(R.drawable.profile, "example8"))
            add(FriendStatusData(R.drawable.profile, "example9"))
            add(FriendStatusData(R.drawable.profile, "example10"))
            add(FriendStatusData(R.drawable.profile, "example11"))
            add(FriendStatusData(R.drawable.profile, "example12"))
        }

        binding.dmBackBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val msgListAdapter = DMMsgListRVAdapter(msgListDatas)
        binding.dmMsgRv.adapter = msgListAdapter
        binding.dmMsgRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        msgListDatas.apply {
            add(DMMsgListData(R.drawable.profile, "example1", "message", 1))
            add(DMMsgListData(R.drawable.profile, "example2", "message", 0))
            add(DMMsgListData(R.drawable.profile, "example3", "message", 1))
            add(DMMsgListData(R.drawable.profile, "example4", "message", 0))
            add(DMMsgListData(R.drawable.profile, "example5", "message", 1))
            add(DMMsgListData(R.drawable.profile, "example6", "message", 0))
            add(DMMsgListData(R.drawable.profile, "example7", "message", 1))
            add(DMMsgListData(R.drawable.profile, "example8", "message", 0))
            add(DMMsgListData(R.drawable.profile, "example9", "message", 1))
            add(DMMsgListData(R.drawable.profile, "example10", "message", 0))
        }

        setContentView(binding.root)
    }
}