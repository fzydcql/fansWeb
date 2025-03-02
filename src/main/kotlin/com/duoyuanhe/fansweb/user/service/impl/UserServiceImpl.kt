package com.duoyuanhe.fansweb.user.service.impl

import com.duoyuanhe.fansweb.extensions.isValidEmail
import com.duoyuanhe.fansweb.extensions.isValidNumeric
import com.duoyuanhe.fansweb.extensions.isValidPhoneNumber
import com.duoyuanhe.fansweb.user.extensions.Type
import com.duoyuanhe.fansweb.user.extensions.validate
import com.duoyuanhe.fansweb.user.mapper.UserMapper
import com.duoyuanhe.fansweb.user.model.User
import com.duoyuanhe.fansweb.user.model.http.ResponseResult
import com.duoyuanhe.fansweb.user.model.http.UserResponseBody
import com.duoyuanhe.fansweb.user.model.http.request.GetVerificationCodeRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserLoginRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserRegisterRequestBody
import com.duoyuanhe.fansweb.user.service.UserService
import com.duoyuanhe.fansweb.verifcode.impl.EmailAdapterImpl
import com.duoyuanhe.fansweb.verifcode.impl.SMSAdapterImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    override fun sentVerificationCode(verificationCodeRequestBody: GetVerificationCodeRequestBody): Any {

        val target = verificationCodeRequestBody.target

        if (target.isEmpty()) {
            return ResponseResult.fail(403, "参数不能为空")
        }
        val verificationAdapter = if (target.isValidNumeric() && target.isValidPhoneNumber()) {
            EmailAdapterImpl(target)
        } else if (target.isValidEmail()) {
            SMSAdapterImpl(target)
        } else {
            return ResponseResult.fail(403, "参数无效")
        }

        val verifyCode = verificationAdapter.generateCode()
        println("生成验证码 --> $verifyCode")
        val sentResult = verificationAdapter.sent(verifyCode)

        return ResponseResult.success(200, "验证码发送成功")
    }

    override fun register(userRegisterRequestBody: UserRegisterRequestBody): ResponseResult {

        userRegisterRequestBody.validate()?.let { return it }

        // todo 校验验证码是否正确


        val type = userRegisterRequestBody.type

        val user = User(
            phoneNumber = userRegisterRequestBody.phone,
            email = userRegisterRequestBody.email,
            password = userRegisterRequestBody.password
        )

        if (checkAccountExists(type, user.phoneNumber, user.email) > 0) {
            return ResponseResult.fail(403, "账号已存在")
        }


        return ResponseResult.success(200, "注册成功", hashMapOf("token" to "Token"))
    }

    override fun login(userLoginRequestBody: UserLoginRequestBody): ResponseResult {

        userLoginRequestBody.validate()?.let { return it }

        val refType = userLoginRequestBody.type
        // 登录查询
        val user = if (refType == Type.REF_TYPE_PHONE) {
            userMapper.findByPhone(userLoginRequestBody.phone!!)
        } else {
            userMapper.findByEmail(userLoginRequestBody.email!!)
        }

        if (user == null) {
            return ResponseResult.fail(403, "用户不存在")
        }

        if (user.password == userLoginRequestBody.password!!) {

            // todo 添加授权 并返会 token

            return ResponseResult.success(200, "登录成功", hashMapOf("token" to "Token"))
        }
        return ResponseResult.fail(403, "登录密码错误")

    }


    private fun checkAccountExists(refType: Int, phone: String?, email: String?): Int {
        var accountExists = 0
        if (refType == Type.REF_TYPE_PHONE) {
            if (userMapper.findByPhone(phone!!) != null) {
                accountExists = 1
            }
        } else {
            if (userMapper.findByEmail(email!!) != null) {
                accountExists = 2
            }
        }
        return accountExists
    }
}