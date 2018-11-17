package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class UserManager {
    // 成功登录后执行该地址
    @RequestMapping("/loginSuccess")
    public ModelAndView modelAndView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("进入用户管理了");
        System.out.println("account"+request.getSession().getAttribute("account"));
        modelAndView.setViewName("usermanager");
        return modelAndView;
    }
    // 获取用户信息
    @RequestMapping("/userManager")
    @ResponseBody
    public JSONObject manager(int code){
        JSONObject jsonObject = new JSONObject();

        // 分页查询得到用户项
        return jsonObject;
    }

}
