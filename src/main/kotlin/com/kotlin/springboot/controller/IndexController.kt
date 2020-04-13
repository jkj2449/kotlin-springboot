package com.kotlin.springboot.controller

import com.kotlin.springboot.service.PostsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {
    @Autowired
    lateinit var postsService: PostsService

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("posts", postsService.findByAllDesc())
        return "index"
    }

    @GetMapping("/posts/save")
    fun postSave() : String {
        return "posts-save"
    }

    @GetMapping("/posts/update/{id}")
    fun postsUpdate(@PathVariable id: Long, model: Model): String {
        val dto = postsService.findById(id)
        model.addAttribute("post", dto)

        return "posts-update"
    }
}