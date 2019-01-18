package school.service;

import school.bean.User;
import school.util.Page;

import java.util.List;

public interface UserService {
    // 分页查询
    List<User> selectLimit(Page page,int type);
    // 获取用户总数
    int total(int type);
    // 按用户名查找
    List<User> selectByName(String name);
    // 按账号查询-->查询相关信息
    User selectInfoByAccount(int account);
    // 根据账号获取用户信息
    User selectByAccount(int account);
    // 修改属性
    int updateUser(User user);
    // 删除用户
    int deleteUser(int account);
    // 客户端注册
    int addUser(User user);
    // 客户端修改属性
    int updateUserByC(User user);
    // 是否成功登录
    User isLoginSuccess(User user);
}
