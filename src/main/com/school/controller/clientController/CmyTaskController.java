package school.controller.clientController;

import com.alibaba.fastjson.JSONObject;
import school.bean.Task;
import school.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
*  客户端我的任务控制器
* */
@Controller
@RequestMapping("")
public class CmyTaskController {
    @Autowired
    TaskService taskService;
    // 获取我的任务
    @RequestMapping("/getMyTask")
    @ResponseBody
    public JSONObject getMyTask(int account){
        System.out.println(account);
        JSONObject jsonObject = new JSONObject();
        List<Task> tasks = taskService.getTaskByIssueaccont(account);
        jsonObject.put("allTasks",tasks);
        return  jsonObject;
    }
    // 发布任务
    @RequestMapping("/issueTask")
    @ResponseBody
    public JSONObject issueTask(String task){
        JSONObject jsonObject = new JSONObject();
        int row = taskService.addTast(task);
        if (row==0){
            jsonObject.put("tasks","");
            return  jsonObject;
        }
        jsonObject.put("tasks","success");
        return  jsonObject;
    }
    // 放弃任务
    @RequestMapping("/giveupMyTask")
    @ResponseBody
    public JSONObject giveupMyTask(String task){
        JSONObject jsonObject = new JSONObject();
        int row = taskService.giveupMyTask(task);
        if (row==0){
            jsonObject.put("tasks","");
            return  jsonObject;
        }
        jsonObject.put("tasks","giveupsuccess");
        return  jsonObject;
    }

}
