package com.duoyuanhe.fansweb.user.model.http.request

import com.duoyuanhe.fansweb.user.extensions.Type

data class UserLoginRequestBody(

    var phone: String? = null,
    var email: String? = null,
    var password: String? = null,
    val signs: String = "",
    /**
     * 注册方式
     * 1、手机号注册
     * 2、邮箱注册
     */
    var type: Int = Type.REF_TYPE_PHONE
)

