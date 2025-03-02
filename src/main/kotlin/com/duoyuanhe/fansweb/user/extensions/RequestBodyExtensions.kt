package com.duoyuanhe.fansweb.user.extensions

import com.duoyuanhe.fansweb.extensions.isValidEmail
import com.duoyuanhe.fansweb.extensions.isValidPassword
import com.duoyuanhe.fansweb.extensions.isValidPhoneNumber
import com.duoyuanhe.fansweb.user.model.http.ResponseResult
import com.duoyuanhe.fansweb.user.model.http.request.UserLoginRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserRegisterRequestBody


data object Type {
    const val REF_TYPE_PHONE = 1
    const val REF_TYPE_EMAIL = 2
}

fun UserRegisterRequestBody.validate(): ResponseResult? {

    if (verificationCode.isNullOrEmpty()) {
        return ResponseResult.success(403, "验证码不能为空")
    }

    return validate2(phone, email, password, type)
}

fun UserLoginRequestBody.validate(): ResponseResult? {

    return validate2(phone, email, password, type)
}

private fun validate2(phone: String?, email: String?, password: String?, type: Int): ResponseResult? {
    if (password.isNullOrEmpty()) {
        return ResponseResult.success(403, "密码不能为空")
    }

    if (type == Type.REF_TYPE_PHONE) {

        if (phone.isNullOrEmpty()) {
            return ResponseResult.success(403, "手机号不能为空")
        }
        if (!phone.isValidPhoneNumber()) {
            return ResponseResult.success(403, "手机号格式不正确")
        }

    } else if (type == Type.REF_TYPE_EMAIL) {
        if (email.isNullOrEmpty()) {
            return ResponseResult.success(403, "邮箱账号不能为空")
        }

        if (!email.isValidEmail()) {
            return ResponseResult.success(403, "邮箱账号不正确")
        }

    } else {
        return ResponseResult.success(403, "尚未支持的注册方式")
    }

    // 校验登录密码是否合法
    if (!password.isValidPassword()) {
        return ResponseResult.success(403, "密码输入不合法")
    }

    return null
}