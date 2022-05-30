package com.example.umc_android_instagram_clone_coding

data class HomeStoryData(
    var id: String? = "",
    var coverImg: Int? = null,

    // 내 스토리, 다른 사람들 스토리 구분
    // Story 확인했는지 안했는지 구분
    // 0 = 내 스토리
    // -1 = 확인한 스토리
    // 1 = 확인하지 않은 스토리
    var status : Int? = null
)