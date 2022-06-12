package com.example.umc_android_instagram_clone_coding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_android_instagram_clone_coding.databinding.ItemDmMsgBinding

class DMMsgListRVAdapter(private var msgList: ArrayList<DMMsgListData>) : RecyclerView.Adapter<DMMsgListRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DMMsgListRVAdapter.ViewHolder {
        val binding: ItemDmMsgBinding = ItemDmMsgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DMMsgListRVAdapter.ViewHolder, position: Int) {
        holder.bind(msgList[position])
    }

    override fun getItemCount(): Int = msgList.size

    inner class ViewHolder(val binding: ItemDmMsgBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (msg: DMMsgListData) {
            binding.itemDmListProfile.setImageResource(R.drawable.profile)
            binding.itemDmListName.text = msg.id
            binding.itemDmMsg.text = msg.msg

            if (msg.storyStatus == 0)
                binding.itemDmListStory.setImageResource(R.drawable.check_story)
            else if (msg.storyStatus == 1)
                binding.itemDmListStory.setImageResource(R.drawable.story_border)
        }
    }

}