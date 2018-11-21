package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.school.bean.User;
import com.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("")
/*
*  这里有针对管理级别设定的，并不是谁都能进入
* */
public class LoginController {
    @Autowired
    LoginService loginService;
    // 登录页面
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView();
        // 取出session会话中的账号和密码
        modelAndView.addObject("account",request.getSession().getAttribute("account"));
        modelAndView.addObject("password",request.getSession().getAttribute("password"));
        // 指定页面
        modelAndView.setViewName("login");
        return modelAndView;
    }
    // 登录控制
    @RequestMapping(value = "/loginController",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loginController(User user, HttpServletRequest request,boolean remember){
        JSONObject jsonObject = new JSONObject();
        request.getSession().setMaxInactiveInterval(30*24*60*60); // session时间位30 天
        request.getSession().setAttribute("account",user.getAccount()); // 记录账号
        // 直接使用bean将导致参数类型不同时报404
        user = loginService.isLoginSuccess(user);
        // 指定页面
        if (user!=null){
            // 成功
            if (remember){
                // 如果点击了记住密码则把密码记录到session会话中
                request.getSession().setAttribute("password",user.getPassword());
            }else {
                // 如果没有点击记住密码，则清空session中的记录,将session中的记录置空
                request.getSession().setAttribute("password","");
            }
            return jsonObject;
        }else {
            // 失败
            System.out.println("失败了");
            // 失败提示
            jsonObject.put("fail","fail");
        }
        return jsonObject;
    }
    // 成功登录后执行该地址
    @RequestMapping("/loginSuccess")
    public ModelAndView modelAndView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        // 设置显示页面
        modelAndView.setViewName("manager");
        return modelAndView;
    }
}
