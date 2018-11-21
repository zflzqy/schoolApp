package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.school.bean.User;
import com.school.service.UserService;
import com.school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("")
// 用户管理控制器
public class UserManager {
    @Autowired
    UserService userService;
    // 获取用户信息
    @RequestMapping("/userManager")
    @ResponseBody
    public JSONObject manager(Page userPage){
        JSONObject jsonObject = new JSONObject();
        // 分页查询得到用户项
        List<User> users = userService.selectLimit(userPage);
        if (users.size()!=0){
            jsonObject.put("users",users); // 成功返回数据
            jsonObject.put("userlast",userPage.getLast());
        }else {
            return  null;
        }
        return jsonObject;
    }
    // 用户名查询
    @RequestMapping("/searchByName")
    @ResponseBody
    public JSONObject searchByName(String name){
        JSONObject jsonObject = new JSONObject();
        List<User> userByName = userService.selectByName(name);
        if (userByName.size()==0){
            return null;
        }
        jsonObject.put("users",userByName);
        return  jsonObject;
    }
    // 账号查询
    @RequestMapping("/searchByAccount")
    @ResponseBody
    public  JSONObject searchByAccount(int account){
        JSONObject jsonObject = new JSONObject();
        User userByAccount = userService.selectByAccount(account);
        if (userByAccount!=null){
            jsonObject.put("users",userByAccount);
        }else {
            return null;
        }
        return jsonObject;
    }
}
