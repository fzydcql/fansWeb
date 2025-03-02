package com.duoyuanhe.fansweb.user.service

import com.duoyuanhe.fansweb.user.model.http.ResponseResult
import com.duoyuanhe.fansweb.user.model.http.request.UserRegisterRequestBody
import com.duoyuanhe.fansweb.user.model.http.UserResponseBody
import com.duoyuanhe.fansweb.user.model.http.request.GetVerificationCodeRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserLoginRequestBody
import com.duoyuanhe.fansweb.verifcode.VerificationAdapter
import org.springframework.stereotype.Service

@Service
interface UserService {

    /**
     *  发送验证码
     */
    fun sentVerificationCode(adapter: VerificationAdapter): Any? {
        return null
    }

    fun sentVerificationCode(verificationCodeRequestBody: GetVerificationCodeRequestBody): Any

    fun register(userRegisterRequestBody: UserRegisterRequestBody): ResponseResult

    fun login(userLoginRequestBody: UserLoginRequestBody): ResponseResult

}