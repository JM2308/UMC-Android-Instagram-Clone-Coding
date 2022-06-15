package com.example.umc_android_instagram_clone_coding.Shop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.Data.Shop
import com.example.umc_android_instagram_clone_coding.databinding.ItemShopBinding

class ShopRVAdapter(private val shopList: ArrayList<Shop>): RecyclerView.Adapter<ShopRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemShopBinding =
            ItemShopBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount(): Int = shopList.size

    inner class ViewHolder(val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shop: Shop) {
            binding.itemShopImgIv.setImageResource(shop.shopImg!!)
        }
    }
}
