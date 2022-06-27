package com.example.umc_android_instagram_clone_coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.Search.SearchRVAdapter
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    private var searchDatas = ArrayList<Search>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentSearchBinding.inflate(inflater,container,false)

        /* 클릭이벤트 */
        binding.searchSearchLinearlayout.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_fl,SearchDetailFragment()).commitAllowingStateLoss()
        }

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        searchDatas.apply {
            add(Search(R.drawable.img_search1,0))
            add(Search(R.drawable.img_search2))
            add(Search(R.drawable.img_search3,1))
            add(Search(R.drawable.img_search4,0))
            add(Search(R.drawable.img_search5,0))
            add(Search(R.drawable.img_search6,1))
            add(Search(R.drawable.img_search7,0))
            add(Search(R.drawable.img_search8))
            add(Search(R.drawable.img_search9))
            add(Search(R.drawable.img_search10,0))
        }

        val searchRVAdapter = SearchRVAdapter(searchDatas)
        binding.searchRv.adapter = searchRVAdapter
        binding.searchRv.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        
        return binding.root
    }
}