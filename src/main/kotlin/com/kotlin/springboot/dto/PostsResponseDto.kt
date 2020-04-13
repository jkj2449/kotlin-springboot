package com.kotlin.springboot.dto

import com.kotlin.springboot.domain.posts.Posts

class PostsResponseDto(var id: Long, var title: String, var content: String, var author: String) {
    constructor(posts: Posts) : this(
            posts.id!!,
            posts.title,
            posts.content,
            posts.author
    )
}
