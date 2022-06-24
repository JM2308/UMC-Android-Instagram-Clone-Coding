package com.example.umc_android_instagram_clone_coding.Data

data class User(
    var uid: String? = null,
    var email: String? = null,
    var name: String? = null,
    var pwd: String? = null,
    var profileImg: Int? = 0,
    var follower: Array<String>? = arrayOf(),
    var following: Array<String>? = arrayOf(),
    var followReceive: Array<String>? = arrayOf(),
    var followSend: Array<String>? = arrayOf(),
    var post: HashMap<String, HashMap<Int, Any>>? = hashMapOf(),
    var story: HashMap<String, HashMap<Int, Any>>? = hashMapOf()
)