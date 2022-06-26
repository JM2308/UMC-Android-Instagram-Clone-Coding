package com.example.umc_android_instagram_clone_coding

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.Search.SearchRVAdapter
import com.example.umc_android_instagram_clone_coding.databinding.FragmentSearchBinding
import com.facebook.internal.instrument.errorreport.ErrorReportHandler.save


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    private var searchDatas = ArrayList<Search>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentSearchBinding.inflate(inflater,container,false)

        /* EditText */
        val save = binding.searchSearchbarEt.text.toString()

        /* 클릭이벤트 */
        binding.searchSearchbarEt.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_fl,SearchDetailFragment()).commitAllowingStateLoss()
            binding.searchRv.visibility = View.GONE //검색바 클릭시 리사이클러뷰 실종
        }

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        searchDatas.apply {
            add(Search(R.drawable.img_search3,0))
            add(Search(R.drawable.img_search2))
            add(Search(R.drawable.img_search3,0))
            add(Search(R.drawable.img_search4,0))
            add(Search(R.drawable.img_search5,0))
            add(Search(R.drawable.img_search6))
            add(Search(R.drawable.img_search7,0))
            add(Search(R.drawable.img_search8))
            add(Search(R.drawable.img_search9))
            add(Search(R.drawable.img_search10,0))
        }

        val searchRVAdapter = SearchRVAdapter(searchDatas) // 더미데이터랑 Adapter 연결
        binding.searchRv.adapter = searchRVAdapter // 리사이클러뷰에 어댑터를 연결
//        binding.searchRv.layoutManager = GridLayoutManager(context, 3)
        binding.searchRv.layoutManager = StaggeredGridLayoutManager(3, GridLayoutManager.VERTICAL)
        
        return binding.root
    }
}