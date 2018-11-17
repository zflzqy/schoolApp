package com.school.dao;

import com.school.bean.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer account);

    int insert(User record);

    User selectByPrimaryKey(Integer account);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    // 判断是否登录
    User selectByAccoAndPass(User user);
    // 获取用户总数
    int total();
}