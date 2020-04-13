package com.kotlin.springboot.dto

import com.kotlin.springboot.domain.posts.Posts

class PostsSaveRequestDto {
    lateinit var title: String
    lateinit var content: String
    lateinit var author: String

    fun toEntity(): Posts {
        return Posts(title, content, author)
    }
}