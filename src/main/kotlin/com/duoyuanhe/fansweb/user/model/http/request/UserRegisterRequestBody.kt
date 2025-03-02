package com.duoyuanhe.fansweb.user.model.http.request

import com.duoyuanhe.fansweb.user.extensions.Type

data class UserRegisterRequestBody(

    var phone: String? = null,
    var email: String? = null,
    var password: String? = null,
    var verificationCode: String? = null,
    /**
     * 登录方式
     * 1、手机号
     * 2、邮箱
     */
    var type: Int = Type.REF_TYPE_PHONE
)

