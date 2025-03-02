package com.duoyuanhe.fansweb.user.model.http

class ResponseResult(
    val code: Int,
    val message: String,
    val data: Any?
) {
    companion object {
        fun success(data: Any): ResponseResult {
            return ResponseResult(200, "OK", data)
        }
        fun success(code: Int, message: String, data: Any): ResponseResult {
            return ResponseResult(code, message, data)
        }
        fun success(code: Int, data: Any): ResponseResult {
            return ResponseResult(code, "OK", data)
        }

        fun  fail(message: String): ResponseResult {
            return ResponseResult(500, message, null)
        }

        fun  fail(code: Int, message: String): ResponseResult {
            return ResponseResult(code, message, null)
        }
    }
}