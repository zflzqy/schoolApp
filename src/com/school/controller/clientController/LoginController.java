package com.school.controller.clientController;

import com.google.gson.Gson;
import com.school.bean.User;
import com.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
* 用的是谷歌的gson
*/
@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    LoginService loginService;
    // 客户端登录处理
    @RequestMapping("/cLogin")
    @ResponseBody
    public Gson cLogin(User user){
        Gson gson = new Gson();
        System.out.println("客户端登录："+user.toString());
//        loginService.isLoginSuccess(user);
        return  gson;
    }
}
