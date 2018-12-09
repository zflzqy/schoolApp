package com.school.dao;

import com.school.bean.User;
import com.school.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 删除保留
    int deleteByPrimaryKey(Integer account);
    // 添加用户--客户端
    int insert(User record);
    // 判断是否登录
    User selectByAccoAndPass(User user);
    // 分页查询
    List<User> selectLimit(Page page);
    // 获取用户总数
    int total();
    // 按用户名查找
    List<User> selectByName(String name);
    // 按账号查询
    User selectByAccount(int account);
    // 修改用户属性
    int updateUserByAccount(User user);
    // 修改用户属性---客户端行为
    int updateUserByC(User user);

}