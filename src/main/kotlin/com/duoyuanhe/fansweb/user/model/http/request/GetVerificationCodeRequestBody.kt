package com.duoyuanhe.fansweb.user.model.http.request

data class GetVerificationCodeRequestBody(
    val target: String = "",
    val type: Int = 0,
    val signs: String = ""
)
