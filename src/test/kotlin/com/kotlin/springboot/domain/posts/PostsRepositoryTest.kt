package com.kotlin.springboot.domain.posts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    lateinit var postsRepository: PostsRepository

    @Test
    fun 게시글저장_불러오기() {
        val title = "테스트 게시글";
        val content = "테스트 본문";
        val author = "jkj8982@gmail.com";

        postsRepository.save(Posts(title, content, author))

        val postsList = postsRepository.findAll();

        val posts = postsList[0];
        assertThat(posts.title).isEqualTo(title);
        assertThat(posts.content).isEqualTo(content);
    }
}