package com.school.service.Impl;

import com.school.bean.User;
import com.school.dao.IssuetaskMapper;
import com.school.dao.ReceivetaskMapper;
import com.school.dao.UserMapper;
import com.school.service.UserService;
import com.school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    IssuetaskMapper issuetaskMapper;
    @Autowired
    ReceivetaskMapper receivetaskMapper;

    @Override
    public List<User> selectLimit(Page page) {
        List<User> users =userMapper.selectLimit(page);
        // 得到总数
        int total = userMapper.total();
        // 计算最后一页
        page.getLastLocation(total);
        for (User user:users){
            // 查询每个用户的发布量
            user.setIssueCount(issuetaskMapper.selectIssueCountByAcount(user.getAccount()));
            // 查询每个用户的领取量
            user.setReceiveCount(receivetaskMapper.selectReceiveCountByAcount(user.getAccount()));
        }
        return users;
    }
    // 获取总数
    @Override
    public int total() {
        return userMapper.total();
    }
    // 按用户名查询
    @Override
    public List<User> selectByName(String name) {
        List<User> users = userMapper.selectByName(name);
        for (User user:users){
            // 查询每个用户的发布量
            user.setIssueCount(issuetaskMapper.selectIssueCountByAcount(user.getAccount()));
            // 查询每个用户的领取量
            user.setReceiveCount(receivetaskMapper.selectReceiveCountByAcount(user.getAccount()));
        }
        return  users;
    }
    // 按账号查询
    @Override
    public User selectByAccount(int account) {
        User user = userMapper.selectByAccount(account);
        if (user==null){
            return null;
        }
        // 查询每个用户的发布量
        user.setIssueCount(issuetaskMapper.selectIssueCountByAcount(user.getAccount()));
        // 查询每个用户的领取量
        user.setReceiveCount(receivetaskMapper.selectReceiveCountByAcount(user.getAccount()));
        return user;
    }
    // 修改属性
    @Override
    public int updateUser(User user){
        return  userMapper.updateUserByAccount(user);
    }

    // 添加客户端用户
    @Override
    public int addUser(User user) {
        System.out.println(userMapper.selectByAccount(user.getAccount()));
        if (userMapper.selectByAccount(user.getAccount())!=null){
            // 用户已经存在
            return  0;
        }
        // 客户端注册人员是type==3
        user.setType(3);
        return  userMapper.insert(user);
    }
    // 客户端修改用户属性
    @Override
    public int updateUserByC(User user){
        return userMapper.updateUserByC(user);
    }
    // 是否成功登录
    @Override
    public User isLoginSuccess(User user) {
        // 调用dao层获取数据
        User u =  userMapper.selectByAccoAndPass(user);
        return u;
    }
}
