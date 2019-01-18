package school.service.Impl;

import school.bean.User;
import school.dao.IssuetaskMapper;
import school.dao.ReceivetaskMapper;
import school.dao.UserMapper;
import school.service.UserService;
import school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<User> selectLimit(Page page,int type) {
        List<User> users =new ArrayList<>();
        if (type==3){
            // 普通管理员
            users = userMapper.selectLimit(page);
        }else if (type==2){
            // 超级管理员
            users = userMapper.selectLimitManager(page);
        }

        // 得到总数
        int total = userMapper.total(type);
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
    public int total(int type) {
        return userMapper.total(type);
    }
    // 按用户名查询
    @Override
    public List<User> selectByName(String name) {
        List<User> users ;
        users = userMapper.selectByName(name);
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
    public User selectInfoByAccount(int account) {
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
    // 根据账号查询
    @Override
    public User selectByAccount(int account) {
        return userMapper.selectByPrimaryKey(account);
    }

    // 修改属性
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int updateUser(User user){
        return  userMapper.updateUserByAccount(user);
    }
    // 删除用户
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int deleteUser(int account) {
        int row= userMapper.deleteByPrimaryKey(account);
        return row;
    }

    // 添加客户端用户
    @Transactional(rollbackFor = Throwable.class)
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
    @Transactional(rollbackFor = Throwable.class)
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
