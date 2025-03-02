package com.duoyuanhe.fansweb.user.controller

import com.duoyuanhe.fansweb.user.model.http.ResponseResult
import com.duoyuanhe.fansweb.user.model.http.UserResponseBody
import com.duoyuanhe.fansweb.user.model.http.request.GetVerificationCodeRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserLoginRequestBody
import com.duoyuanhe.fansweb.user.model.http.request.UserRegisterRequestBody
import com.duoyuanhe.fansweb.user.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@Tag(name = "示例 API", description = "包含一些示例接口")
class UserController {

    @Autowired
    private lateinit var userService: UserService


    @Operation(summary = "根据手机号或邮箱获取验证码")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "成功获取验证码"
        ), ApiResponse(responseCode = "400", description = "参数无效，需提供手机号或邮箱")]
    )

    @PostMapping("/getVerificationCode")
    fun getVerificationCode(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            description = """
                - target: 接收目标（邮箱/手机号）
                - type: 1 注册账号，2 忘记密码
                - signs：没有通过人机验证接口的signs无法发送短信（暂时无用）
                """,
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "发送短信验证码",
                            value = """{"target": "13800138000","type": 1,"signs":""}"""
                        ),
                        ExampleObject(
                            name = "发送邮箱验证码",
                            value = """{"target": "1121744186@qq.com","type": 1,"signs":""}"""
                        )
                    ]
                )
            ]
        )
        @RequestBody verificationCodeRequestBody: GetVerificationCodeRequestBody
    ): Any {
        return userService.sentVerificationCode(verificationCodeRequestBody)
    }


    @PostMapping("/register")
    @Operation(summary = "用户注册接口", description = "根据手机号或邮箱、密码进行注册")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "注册成功",
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [
                        ExampleObject(
                            name = "注册成功",
                            value = """{"target": "13800138000","type": 1,"signs":""}"""
                        )
                    ]
                )
            ]
        )]
    )
    fun register(@RequestBody userRegisterRequestBody: UserRegisterRequestBody): Any {
        return userService.register(userRegisterRequestBody)
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录接口", description = "使用手机号或邮箱加密码进行登录")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "登录成功"),
            ApiResponse(responseCode = "400", description = "用户不存在或密码错误")
        ]
    )
    fun login(@RequestBody userLoginRequestBody: UserLoginRequestBody): ResponseResult {
        return userService.login(userLoginRequestBody)
    }


}