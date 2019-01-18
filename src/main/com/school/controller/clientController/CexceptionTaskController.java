package school.controller.clientController;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import school.bean.Task;
import school.bean.User;
import school.service.TaskService;
import school.service.UserService;

import java.util.List;

/*
*  异常任务
* */
@Controller
@RequestMapping("")
public class CexceptionTaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;
    // 获取我的异常任务(自己的和别人的)
    @RequestMapping("/getMyExceptionTask")
    @ResponseBody
    public JSONObject getMyExceptionTask(int account){
        JSONObject jsonObject = new JSONObject();
        List<Task> tasks = taskService.getMyExceptionTask(account);
        jsonObject.put("allTasks",tasks);
        return  jsonObject;
    }
    // 获取用户信息
    @RequestMapping("/exceGetUser")
    @ResponseBody
    public  JSONObject SearchByAccount(int account){
        JSONObject jsonObject = new JSONObject();
        User userByAccount = userService.selectByAccount(account);
        if (userByAccount!=null){
            jsonObject.put("user",userByAccount);
        }else {
            jsonObject.put("user","");
        }
        return jsonObject;
    }
}
