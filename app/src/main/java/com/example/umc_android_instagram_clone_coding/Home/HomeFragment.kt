package com.example.umc_android_instagram_clone_coding.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_android_instagram_clone_coding.Data.HomeStoryData
import com.example.umc_android_instagram_clone_coding.Data.PostContentItem
import com.example.umc_android_instagram_clone_coding.Login.LoginActivity
import com.example.umc_android_instagram_clone_coding.MainActivity
import com.example.umc_android_instagram_clone_coding.R
import com.example.umc_android_instagram_clone_coding.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding : FragmentHomeBinding
    private var storyDatas = ArrayList<HomeStoryData>()
    private var postDatas = ArrayList<PostContentItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        Log.d("DataCheck", "current user = " + FirebaseAuth.getInstance().currentUser)

        // StoryItem & Data ??????
        applyStoryData()
        // PostItem & Data ??????
        applyPostData()

        binding.homeAddBtn.setOnClickListener {
            var popupMenu = PopupMenu(context, it)
            popupMenu.menuInflater.inflate(R.menu.home_add_btn_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                if (menuItem.itemId === R.id.post) {
                    // Toast.makeText(activity, "????????? ??????", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(activity, PostSelectImgActivity::class.java))
                } else if (menuItem.itemId === R.id.story) {
                    Toast.makeText(activity, "????????? ??????", Toast.LENGTH_SHORT).show()
                } else if (menuItem.itemId === R.id.reels) {
                    Toast.makeText(activity, "?????? ??????", Toast.LENGTH_SHORT).show()
                }  else {
                    Toast.makeText(activity, "????????? ??????", Toast.LENGTH_SHORT).show()
                }
                false
            }
            popupMenu.show()
        }

        binding.homeHeartBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_fl, NoticeFragment()).commitAllowingStateLoss()
        }

        // log-out test Button
        binding.homeDmBtn.setOnClickListener {
            startActivity(Intent(context, DMActivity::class.java))
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun applyStoryData() {

        // story??? ????????? ???????????? RV ???????????? ?????? Adapter ??????
        val storyAdapter = HomeStoryRVAdapter(storyDatas)
        binding.homeStoryRv.adapter = storyAdapter
        binding.homeStoryRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // storyDatas??? ?????? data ???????????? ??????
        storyDatas.apply {
            add(HomeStoryData("??? ?????????", R.drawable.profile, 0))
            add(HomeStoryData("example1", R.drawable.profile, 1))
            add(HomeStoryData("example2", R.drawable.profile, 1))
            add(HomeStoryData("example3", R.drawable.profile, 1))
            add(HomeStoryData("example4", R.drawable.profile, -1))
            add(HomeStoryData("example5", R.drawable.profile, -1))
        }

//        // story ?????????????????? ????????? ?????? ??????
//        storyAdapter.setMyItemClickListener(object: HomeStoryRVAdapter.MyItemClickListener{
//            override fun onItemClick() {
//                startActivity(Intent(activity, StoryActivity::class.java))
//            }
//        })
    }

    private fun applyPostData() {
        // post??? ????????? ???????????? RV ???????????? ?????? Adapter ??????
        val postAdapter = PostContentRVAdapter(postDatas)
        binding.homePostRv.adapter = postAdapter
        binding.homePostRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // postDatas??? ?????? data ???????????? ??????
        postDatas.apply {
            add(
                PostContentItem(
                    R.drawable.profile, "exampleID1", R.color.black, "1", "exampleID content~~",
                "1", "1??? ???", 1)
            )
            add(
                PostContentItem(
                    R.drawable.profile, "exampleID2", R.color.black, "2", "exampleID content~~",
                "2", "2??? ???", 1)
            )
            add(
                PostContentItem(
                    R.drawable.profile, "exampleID3", R.color.black, "3", "exampleID content~~",
                "3", "3??? ???", 1)
            )
            add(
                PostContentItem(
                    R.drawable.profile, "exampleID4", R.color.black, "4", "exampleID content~~",
                "4", "4??? ???", 0)
            )
            add(
                PostContentItem(
                    R.drawable.profile, "exampleID5", R.color.black, "5", "exampleID content~~",
                "5", "5??? ???", 0)
            )
        }
    }
}