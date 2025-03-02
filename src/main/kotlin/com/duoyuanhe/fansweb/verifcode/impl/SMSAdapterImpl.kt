package com.duoyuanhe.fansweb.verifcode.impl

import com.duoyuanhe.fansweb.verifcode.VerificationAdapter
import kotlin.random.Random

class SMSAdapterImpl(var phoneNumber: String) : VerificationAdapter {

    override fun generateCode(length: Int?): String {
        return CharArray(length ?: 6) {
            ('0'.code + Random.nextInt(10)).toChar()
        }.concatToString()
    }

    override fun sent(code: String): Boolean {
        println("发送验证码至手机号 --> $code")
        return true
    }

}