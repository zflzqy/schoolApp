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
 *  客户端领取任务控制器
 * */
@Controller
@RequestMapping("/")
public class CreceiveTaskController {
    @Autowired
    TaskService taskService;
    // 获取所有非自己的任务
    @RequestMapping("/getAllTask")
    @ResponseBody
    public JSONObject getAllTask(int account){
        JSONObject jsonObject = new JSONObject();
        List<Task> allTask = taskService.getAllTask(account);
        System.out.println(allTask.size());
        jsonObject.put("allTasks",allTask);
        return jsonObject;
    }
    // 领取任务
    @RequestMapping("/receiveTask")
    @ResponseBody
    public JSONObject receiveTask(String task){
        JSONObject jsonObject = new JSONObject();
        int row = taskService.receiveTask(task);
        if (row==0){
            // 没有领取成功
            jsonObject.put("tasks","");
            return  jsonObject;
        }
        jsonObject.put("tasks","gettasksuccess");
        return  jsonObject;
    }
    // 已领任务
    @RequestMapping("/haveReciveTask")
    @ResponseBody
    public JSONObject haveReciveTask(int account){
        JSONObject jsonObject = new JSONObject();
        List<Task> allTask = taskService.gethaveReceiveTask(account);
        System.out.println(allTask.size());
        jsonObject.put("allTasks",allTask);
        return jsonObject;
    }
    // 完成任务
    @RequestMapping("/finishTask")
    @ResponseBody
    public JSONObject finishTask(String task){
        JSONObject jsonObject = new JSONObject();
        int row = taskService.finishedTask(task);
        if (row==0){
            jsonObject.put("tasks","");
            return  jsonObject;
        }
        jsonObject.put("tasks","FINISHTASK");
        return jsonObject;
    }
}
