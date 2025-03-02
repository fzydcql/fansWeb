package com.duoyuanhe.fansweb


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
	"com.duoyuanhe.fansweb.user.controller",
	"com.duoyuanhe.fansweb.user.service",
	"com.duoyuanhe.fansweb.user.mapper"
)
class FanswebApplication

fun main(args: Array<String>) {
	runApplication<FanswebApplication>(*args)
}
