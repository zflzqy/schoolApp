package com.school.service;

import com.school.bean.User;
import com.school.util.Page;

import java.util.List;

public interface UserService {
    // 分页查询
    List<User> selectLimit(Page page);
    // 获取用户总数
    int total();
    // 按用户名查找
    List<User> selectByName(String name);
    // 按账号查询
    User selectByAccount(int account);
    // 修改属性
    int updateUser(User user);
    // 客户端注册
    int addUser(User user);
}
