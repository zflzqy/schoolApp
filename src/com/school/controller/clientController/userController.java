package com.school.controller.clientController;

import com.google.gson.Gson;
import com.school.bean.User;
import com.school.service.LoginService;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/*
* 用的是谷歌的gson
*/
@Controller
@RequestMapping("")
public class userController {
    Gson gson = new Gson(); // 处理数据
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    // 客户端登录处理
    @RequestMapping("/cLogin")
    @ResponseBody
    public String cLogin(String userStr){
        User user = loginService.isLoginSuccess(gson.fromJson(userStr, User.class));
        if (user==null){
            // 没有查询到
            return "loginfail";
        }else {
            // 密码置空
            user.setPassword("");
            // 返回用户信息
            return gson.toJson(user);
        }
    }
    // 客户端注册处理
    @RequestMapping("/register")
    @ResponseBody
    public String cRegister(String userStr){
        System.out.println(userStr);
        int row = userService.addUser(gson.fromJson(userStr,User.class));
        if (row==0){
            // 用户已存在
            return "exists";
        }
        // 成功注册
        return  "successregister";
    }
    // 客户端完善信息
    @RequestMapping("/perfectInformation")
    @ResponseBody
    public String perfectInformation(MultipartFile file,String userStr){
        System.out.println(file.getOriginalFilename());
        System.out.println(userStr);
        return null;
    }
}
