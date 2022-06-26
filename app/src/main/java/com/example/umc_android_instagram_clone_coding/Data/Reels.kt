package com.example.umc_android_instagram_clone_coding.Data

data class Reels(
    var userId: String? = "",   //사용자 아이디
    var title: String? = "",    //릴스 제목
    var profileImg: Int? = null, //사용자 프로필
//    var music: String? = "",
    var likes: String? = "",     //좋아요 수
    var chat: String? = ""      //채팅 수
)
