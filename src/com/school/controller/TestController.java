package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class TestController {
    @RequestMapping("/testLogin")
    public ModelAndView testLogin(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping("/tsetUserManager")
    public ModelAndView tsetUserManager(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("usermanager");
        return modelAndView;
    }
}
