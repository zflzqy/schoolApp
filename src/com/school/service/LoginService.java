package com.school.service;

import com.school.bean.User;

import java.util.Map;

/*
* 登录接口
* */
public interface LoginService {
    // 是否成功登录
    User isLoginSuccess(User user);
}
