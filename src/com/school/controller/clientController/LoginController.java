package com.school.controller.clientController;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
* 用的是谷歌的gson
*/
@Controller
@RequestMapping("")
public class LoginController {
    // 客户端登录处理
    @RequestMapping("/cLogin")
    @ResponseBody
    public Gson cLogin(){
        Gson gson = new Gson();
        return  gson;
    }
}
