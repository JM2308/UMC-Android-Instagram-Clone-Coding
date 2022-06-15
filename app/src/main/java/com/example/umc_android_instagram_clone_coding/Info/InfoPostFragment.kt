package com.example.umc_android_instagram_clone_coding.Info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.PostItem
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoPostBinding

class InfoPostFragment : Fragment() {
    private var _binding: FragmentInfoPostBinding? = null
    private val binding get() = _binding!!

    private var postItems = arrayListOf<PostItem>( // 피드에 들어갈 이미지 리스트
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol),
        PostItem(R.drawable.jindol)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoPostBinding.inflate(inflater, container, false)

        connectAdapter()

        return binding.root
    }

    private fun connectAdapter() {
        val mAdapter = InfoPostRVAdapter(postItems)
        binding.infoPostRv.adapter = mAdapter

        val gridLayoutManager = GridLayoutManager(context,3)
        binding.infoPostRv.layoutManager = gridLayoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}