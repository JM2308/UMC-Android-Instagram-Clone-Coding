package com.example.umc_android_instagram_clone_coding

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Search
import com.example.umc_android_instagram_clone_coding.Login.SignupActivity
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

        /* 클릭이벤트 */
        binding.searchSearchbarEt.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_fl,SearchDetailFragment())
                .commitAllowingStateLoss()
        }

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        searchDatas.apply {
            add(Search(R.drawable.img_search9,0))
            add(Search(R.drawable.img_search2,0))
            add(Search(R.drawable.img_search3))
            add(Search(R.drawable.img_search4,0))
            add(Search(R.drawable.img_search5,0))
            add(Search(R.drawable.img_search6))
            add(Search(R.drawable.img_search7,0))
            add(Search(R.drawable.img_search8))
            add(Search(R.drawable.img_search9))
            add(Search(R.drawable.img_search3,0))
            add(Search(R.drawable.img_search10))
            add(Search(R.drawable.img_search5,0))
            add(Search(R.drawable.img_search6))
            add(Search(R.drawable.img_search7,0))
            add(Search(R.drawable.img_search8))
            add(Search(R.drawable.img_search9))
            add(Search(R.drawable.img_search10,0))
        }

        val searchRVAdapter = SearchRVAdapter(searchDatas) // 더미데이터랑 Adapter 연결
        binding.searchRv.adapter = searchRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.searchRv.layoutManager = GridLayoutManager(context, 3)

        /* EditText 입력값 전달 -> 루나 사랑해요.. */
//        // 이동할 Fragment 선언
//        var nextFragment = SearchDetailFragment()
//
//
//        // 전송할 데이터를 "Bundle"에 넣어 전달
//        var bundle = Bundle()
//
//        val id = bundle.getString("id")
//        val name = bundle.getString("name")
//        bundle.putString("id", id)
//        bundle.putString("name", name)
//
//        // 이동할 Fragment의 Argument로 데이터를 넣어주는 형태
//        nextFragment.arguments = bundle
//
//        // Fragment -> Fragment 이동
//        activity?.supportFragmentManager!!.beginTransaction()
//            .replace(R.id.main_fl, nextFragment)
//            .commit()

//        // editText에서 엔터키 클릭 시
//        binding.searchSearchbarEt.setOnEditorActionListener { v, actionId, event ->
//            var handled = false
//
//            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                (context as MainActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.main_fl,SearchDetailFragment())
//                    .commitAllowingStateLoss()
//                handled = true
//            }
//            handled
//        }
        
        return binding.root
    }
}