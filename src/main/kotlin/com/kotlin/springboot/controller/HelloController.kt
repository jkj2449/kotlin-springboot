package com.kotlin.springboot.controller

import com.kotlin.springboot.dto.HelloResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @GetMapping("/hello/dto")
    fun hello(@RequestParam name: String, @RequestParam amount: Int): HelloResponseDto {
        return HelloResponseDto(name, amount)
    }
}