package com.school.controller.clientController;

import com.google.gson.Gson;
import com.school.bean.User;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/*
* 用的是谷歌的gson
*/
@Controller
@RequestMapping("")
public class CuserController {
    Gson gson = new Gson(); // 处理数据
    @Autowired
    UserService userService;
    // 客户端登录处理
    @RequestMapping("/cLogin")
    @ResponseBody
    public String cLogin(String userStr){
        User user = userService.isLoginSuccess(gson.fromJson(userStr, User.class));
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
    public String perfectInformation(MultipartFile file, String userStr, HttpServletRequest request){
        // 这里的路径由于idea热部署的原因不会将项目部署到tomcat目录下，所有手动创建路径
        // 1.先将文件保存在本地服务器上
        // 1.1获得文件名，客户端中均以该用户账户命名
        String fileName = file.getOriginalFilename();
        File uploadFile = new File("E:/idea/ideaCode/schoolApp/images",fileName);
        if (uploadFile.exists()){
            // 如果文件存在的话,防止用户两次上传图片不一致(取最近一次)
            if (uploadFile.delete()){
                // 成功删除文件
                try {
                    // 新建文件
                    uploadFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            // 文件不存在
            try {
                uploadFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 输出文件信息,相当于将上传的文件复制到了新的文件上
            file.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.往数据库中填信息
        User user = gson.fromJson(userStr,User.class);
        // 2.1 修改文件存放位置
        user.setPath(uploadFile.getAbsolutePath());
        // 2.2 数据库操作
        int row = userService.updateUserByC(user);
        if (row!=0){
            // 成功
            return "successperfect";
        }
        return ""; // 没有成功
    }
}
