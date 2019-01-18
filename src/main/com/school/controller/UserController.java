package school.controller;

import com.alibaba.fastjson.JSONObject;
import school.bean.User;
import school.service.UserService;
import school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
// 用户管理控制器
public class UserController {
    @Autowired
    UserService userService;
    // 获取用户信息
    @RequestMapping("/getUser")
    @ResponseBody
    public JSONObject getUser(Page userPage,int type){
        JSONObject jsonObject = new JSONObject();
        // 分页查询得到用户项
        List<User> users = userService.selectLimit(userPage,type);
        if (users.size()!=0){
            jsonObject.put("users",users); // 成功返回数据
            jsonObject.put("userlast",userPage.getLast());
        }else {
            return  null;
        }
        return jsonObject;
    }
    // 用户名查询
    @RequestMapping("/searchByName")
    @ResponseBody
    public JSONObject SearchByName(String name){
        JSONObject jsonObject = new JSONObject();
        List<User> userByName = userService.selectByName(name);
        if (userByName.size()==0){
            return null;
        }
        jsonObject.put("users",userByName);
        return  jsonObject;
    }
    // 账号查询
    @RequestMapping("/searchByAccount")
    @ResponseBody
    public  JSONObject SearchByAccount(int account){
        JSONObject jsonObject = new JSONObject();
        User userByAccount = userService.selectInfoByAccount(account);
        if (userByAccount!=null){
            jsonObject.put("users",userByAccount);
        }else {
            return null;
        }
        return jsonObject;
    }
    // 详细跳转
    @RequestMapping("/turnUserDetail")
    public ModelAndView turnUserDetail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detail");
        return modelAndView;
    }
    // 修改属性
    @RequestMapping("/updateUser")
    @ResponseBody
    public JSONObject updateUser(User user){
        JSONObject jsonObject = new JSONObject();
        System.out.println(user.toString());
        // 影响的行数
        int row = userService.updateUser(user);
        if (row==0){
            // 如果影响的行数为0
            return null;
        }
        return jsonObject;
    }
    // 删除用户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public JSONObject deleteUser(int account){
        JSONObject jsonObject = new JSONObject();
        int row = userService.deleteUser(account);
        if (row==0){
            return  null;
        }
        return  jsonObject;
    }
}
