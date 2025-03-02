package com.duoyuanhe.fansweb.user.model.http

data class UserResponseBody(
    var code: Int = -1,
    var message: String = "",
    var token: String? = null,
    var data: Any? = null
)
