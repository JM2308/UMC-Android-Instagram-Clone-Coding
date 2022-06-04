package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.umc_android_instagram_clone_coding.databinding.FragmentInfoPostBinding

class InfoPostFragment : Fragment() {
    lateinit var binding: FragmentInfoPostBinding
    private var postItems = arrayListOf<PostItem>(
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
        binding = FragmentInfoPostBinding.inflate(inflater, container, false)

        val mAdapter = InfoPostRVAdapter(postItems)
        binding.infoPostRv.adapter = mAdapter

        val gridLayoutManager = GridLayoutManager(context,3)
        binding.infoPostRv.layoutManager = gridLayoutManager

        return binding.root
    }
}