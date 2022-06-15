package com.example.umc_android_instagram_clone_coding.Reels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.umc_android_instagram_clone_coding.Data.Reels
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentReelsBinding

class ReelsFragment : Fragment() {
    lateinit var binding: FragmentReelsBinding
    private var reelsDatas = ArrayList<Reels>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentReelsBinding.inflate(inflater,container,false)

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        reelsDatas.apply {
            add(Reels("umc_makeuschallege","디자이너 절찬 모집중!! 많은 지원 바랍니다(5/25 ~ 6/9)", R.drawable.umc))
            add(Reels("nah25_01","잠수오리", R.drawable.info))
            add(Reels("jimmmminin__00","루나 뭐해요 보고싶어요", R.drawable.info))
            add(Reels("seung__hee_","시험 잘 봤어요? 과탑 기대하고 있을게요 해리", R.drawable.info))
        }

        val reelsRVAdapter = ReelsRVAdapter(reelsDatas) // 더미데이터랑 Adapter 연결
        binding.reelsRv.adapter = reelsRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.reelsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false) //레이아웃 매니저 설정

        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.reelsRv)

        binding.reelsRv.apply {
            layoutManager = layoutManager
            adapter = reelsRVAdapter
        }

        return binding.root
    }
}