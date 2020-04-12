package com.kotlin.springboot.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController {
    @GetMapping("/")
    fun index(): ModelAndView {
        val mav = getModelAndView("Home", "index")
        return mav
    }

    @GetMapping("/sign")
    fun sign(): ModelAndView {
        val mav = getModelAndView("Sign", "sign")
        return mav
    }

    @GetMapping("/login")
    fun login(): ModelAndView {
        val mav = getModelAndView("Login", "login")
        return mav
    }

    private fun getModelAndView(title: String, path: String): ModelAndView {
        val mav = ModelAndView()
        mav.addObject("title", title)
        mav.viewName = path
        return mav
    }
}