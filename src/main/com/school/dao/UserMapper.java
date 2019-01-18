package school.dao;

import school.bean.User;
import school.util.Page;

import java.util.List;

public interface UserMapper {
    // 根据账号获取用户信息
    User selectByPrimaryKey(int account);
    // 删除保留
    int deleteByPrimaryKey(Integer account);
    // 添加用户--客户端
    int insert(User record);
    // 判断是否登录
    User selectByAccoAndPass(User user);
    // 分页查询-->不查询管理员
    List<User> selectLimit(Page page);
    // 分页查询-->查询管理员
    List<User> selectLimitManager(Page page);
    // 获取用户总数(不同用户)
    int total(int type);
    // 按用户名查找---》普通用户
    List<User> selectByName(String name);
//    // 按用户名查找--》管理员用户
//    List<User> selectByNameManager(String name);
    // 按账号查询---》普通用户
    User selectByAccount(int account);
//    // 按账号查询---》管理员用户
//    User selectByAccountMnager(int account);
    // 修改用户属性
    int updateUserByAccount(User user);
    // 修改用户属性---客户端行为
    int updateUserByC(User user);

}