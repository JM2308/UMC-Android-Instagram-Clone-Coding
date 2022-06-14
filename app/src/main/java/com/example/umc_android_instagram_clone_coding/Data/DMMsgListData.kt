package com.example.umc_android_instagram_clone_coding.Data

data class DMMsgListData(
    var profile: Int? = null,
    var id: String? = "",
    var msg: String? = "",
    // 스토리 올렸는지 아닌지 확인
    var storyStatus: Int? = null
)
