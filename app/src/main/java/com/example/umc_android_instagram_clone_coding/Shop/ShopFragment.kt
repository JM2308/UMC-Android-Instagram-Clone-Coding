package com.example.umc_android_instagram_clone_coding.Shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.Shop
import com.example.umc_android_instagram_clone_coding.LoginActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentShopBinding

class ShopFragment : Fragment() {
    lateinit var binding: FragmentShopBinding
    private var shopDatas = ArrayList<Shop>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)

        /* 클릭시 위시리시트로 전환 */
        binding.shopWishlistKeepIv.setOnClickListener {
            startActivity(Intent(activity, WishListActivity::class.java))
//            startActivity(Intent(activity, LoginActivity::class.java))
        }

        // 데이터 리스트 생성 더미 데이터 (arraylist에 담길 데이터)
        shopDatas.apply {
            add(Shop(R.drawable.img_shop1))
            add(Shop(R.drawable.img_shop2))
            add(Shop(R.drawable.img_shop3))
            add(Shop(R.drawable.img_shop4))
            add(Shop(R.drawable.img_shop5))
            add(Shop(R.drawable.img_shop6))
            add(Shop(R.drawable.img_shop7))
            add(Shop(R.drawable.img_shop3))
        }

        val shopRVAdapter = ShopRVAdapter(shopDatas) // 더미데이터랑 Adapter 연결
        binding.shopRv.adapter = shopRVAdapter // 리사이클러뷰에 어댑터를 연결
        binding.shopRv.layoutManager = GridLayoutManager(context, 2)
        return binding.root
    }
}