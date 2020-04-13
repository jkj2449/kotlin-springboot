package com.kotlin.springboot.service

import com.kotlin.springboot.domain.posts.PostsRepository
import com.kotlin.springboot.dto.PostsListResponseDto
import com.kotlin.springboot.dto.PostsResponseDto
import com.kotlin.springboot.dto.PostsSaveRequestDto
import com.kotlin.springboot.dto.PostsUpdateRequestDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class PostsService {
    @Autowired
    lateinit var postsRepository: PostsRepository

    @Transactional
    fun save(requestDto: PostsSaveRequestDto): Long {
        return postsRepository.save(requestDto.toEntity()).id!!
    }

    @Transactional
    fun update(id: Long, requestDto: PostsUpdateRequestDto): Long {
        val posts = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$id") }
        posts.update(requestDto.title, requestDto.content)
        return id
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): PostsResponseDto {
        val posts = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id=$id") }
        return PostsResponseDto(posts)
    }

    @Transactional(readOnly = true)
    fun findByAllDesc(): List<PostsListResponseDto>? {
        return postsRepository.findAllDesc().stream().map { PostsListResponseDto(it) }.collect(Collectors.toList())
    }
}