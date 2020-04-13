package com.kotlin.springboot.domain.posts

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Posts(_title: String, _content: String, _author: String): BaseTimeEntity() {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(length = 500, nullable = false)
    var title: String = _title

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String = _content

    val author: String = _author

    fun update(title: String, content: String) {
        this.title = title;
        this.content = content;
    }
}