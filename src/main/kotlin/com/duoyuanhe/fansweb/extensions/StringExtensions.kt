package com.duoyuanhe.fansweb.extensions

private val EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}\$".toRegex()
private val PHONE_NUMBER_REGEX = "^1[3-9]\\d{9}\$".toRegex()
private val NUMBER_REGEX = "^\\d+$".toRegex()
private val PASSWORD_REGEX = "^[A-Za-z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]{6,20}$".toRegex()

fun String.isValidEmail(): Boolean {
    return this.matches(EMAIL_REGEX)
}

fun String.isValidPhoneNumber(): Boolean {
    return this.matches(PHONE_NUMBER_REGEX)
}

fun String.isValidNumeric(): Boolean {
    return this.matches(NUMBER_REGEX)
}

fun String.isValidPassword(): Boolean {
    return this.matches(PASSWORD_REGEX)
}