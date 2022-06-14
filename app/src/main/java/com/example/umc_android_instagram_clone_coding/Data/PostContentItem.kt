package com.example.umc_android_instagram_clone_coding.Data

data class PostContentItem(
    var profile: Int? = null,
    var id: String? = "",
    var img: Int? = null,
    var like: String? = "",
    var content: String? = "",
    var comment: String? = "",
    var date: String? = "",

    // 스토리 올렸는지 아닌지 확인
    var storyStatus: Int? = null
)