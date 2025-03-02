package com.duoyuanhe.fansweb.verifcode.impl

import com.duoyuanhe.fansweb.verifcode.VerificationAdapter
import kotlin.random.Random

class EmailAdapterImpl(private var email: String) : VerificationAdapter {

    override fun generateCode(length: Int?): String {
        return CharArray(length ?: 6) {
            ('0'.code + Random.nextInt(10)).toChar()
        }.concatToString()
    }

    override fun sent(code: String): Boolean {
        println("发送验证码至邮箱  [ $email ]  --> $code")
        return true
    }
}