package com.kotlin.springboot.controller

import com.kotlin.springboot.dto.PostsResponseDto
import com.kotlin.springboot.dto.PostsSaveRequestDto
import com.kotlin.springboot.dto.PostsUpdateRequestDto
import com.kotlin.springboot.service.PostsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PostsApiController {
    @Autowired
    lateinit var postsService: PostsService

    @PostMapping("/api/v1/posts")
    fun save(@RequestBody requestDto: PostsSaveRequestDto) : Long {
        return postsService.save(requestDto)
    }

    @PutMapping("/api/v1/posts/{id}")
    fun update(@PathVariable id: Long, @RequestBody requestDto: PostsUpdateRequestDto): Long {
        return postsService.update(id, requestDto)
    }

    fun findById(@PathVariable id: Long): PostsResponseDto {
        return postsService.findById(id)
    }
}