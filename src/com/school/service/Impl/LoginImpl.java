package com.school.service.Impl;

import com.school.bean.User;
import com.school.dao.UserMapper;
import com.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("LoginService")
public class LoginImpl implements LoginService {
    @Autowired
    UserMapper mapper;
    @Override
    public User isLoginSuccess(User user) {
        // 调用dao层获取数据
        User u =  mapper.selectByAccoAndPass(user);
        return u;
    }
}
