package com.duoyuanhe.fansweb.user.model

data class UserInfo(
    var avatar: String? = null,
    var nickname: String? = null,
    var gender: Int = 0,
    var address: String? = null
)