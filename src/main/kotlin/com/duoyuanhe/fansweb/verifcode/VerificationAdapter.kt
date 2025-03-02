package com.duoyuanhe.fansweb.verifcode

interface VerificationAdapter {
    fun generateCode(length: Int? = 6): String
    fun sent(code: String): Boolean
}