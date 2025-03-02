package com.duoyuanhe.fansweb.general

data object RespCode {

    // 成功状态码
    const val SUCCESS: Int = 200
    const val SUCCESS_MSG: String = "操作成功"

    // 客户端错误状态码
    const val BAD_REQUEST: Int = 400
    const val BAD_REQUEST_MSG: String = "请求参数错误"

    const val UNAUTHORIZED: Int = 401
    const val UNAUTHORIZED_MSG: String = "未授权，请先登录"

    const val FORBIDDEN: Int = 403
    const val FORBIDDEN_MSG: String = "禁止访问，没有权限"

    const val NOT_FOUND: Int = 404
    const val NOT_FOUND_MSG: String = "请求的资源不存在"

    // 服务器错误状态码
    const val NOT_FOUND_USER: Int = 405
    const val NOT_FOUND_USER_ERROR_MSG: String = "用户不存在或者密码错误"

    // 服务器错误状态码
    const val INTERNAL_SERVER_ERROR: Int = 500
    const val INTERNAL_SERVER_ERROR_MSG: String = "服务器内部错误"

    const val SERVICE_UNAVAILABLE: Int = 503
    const val SERVICE_UNAVAILABLE_MSG: String = "服务不可用，请稍后再试"

    // 手机号格式不正确
    const val NOT_ALLOW_PHONE_RULE: Int = 60001
    const val NOT_ALLOW_PHONE_RULE_ERROR_MSG: String = "手机号格式不正确"

    const val NOT_ALLOW_EMAIL_RULE: Int = 60002
    const val NOT_ALLOW_EMAIL_RULE_ERROR_MSG: String = "邮箱格式不正确"

    // 手机号已注册，请使用新的手机号注册
    const val PHONE_NUMBER_ALREADY_EXISTS: Int = 60003
    const val PHONE_NUMBER_ALREADY_EXISTS_ERROR_MSG: String = "手机号已注册，请使用新的手机号注册"

    const val EMAIL_ALREADY_EXISTS: Int = 60004
    const val EMAIL_ALREADY_EXISTS_ERROR_MSG: String = "邮箱号已注册，请使用新的邮箱号注册"

    // 请填写正确的手机号或者邮箱号
    const val INVALID_PARAM_FAILED: Int = 60005
    const val INVALID_PARAM_FAILED_ERROR_MSG: String = "请填写正确的手机号或者邮箱号"

    // 验证码错误或已失效，请重新获取验证码
    const val VERIFICATION_CODE_ERROR: Int = 60006
    const val VERIFICATION_CODE_ERROR_MSG: String = "验证码错误或已失效，请重新获取验证码"

    // 服务器错误状态码
    const val REGISTRATION_FAILED: Int = 60007
    const val REGISTRATION_FAILED_ERROR_MSG: String = "注册失败，请重新注册"

    const val UPDATE_USERINFO_FAILED: Int = 60008
    const val UPDATE_USERINFO_FAILED_ERROR_MSG: String = "更新用户基本信息失败"

}