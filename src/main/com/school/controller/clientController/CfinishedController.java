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
*  已完成任务
* */
@Controller
@RequestMapping("")
public class CfinishedController {
    @Autowired
    TaskService taskService;
    // 获取所有已完成任务
    @RequestMapping("/getFinishedTask")
    @ResponseBody
    public JSONObject getFinishedTask(int account){
        JSONObject jsonObject = new JSONObject();
        System.out.println(account);
        List<Task> myAllFinishedTask = taskService.getMyAllFinishedTask(account);
        if (myAllFinishedTask.size()==0){
            jsonObject.put("allTasks","");
        }
        jsonObject.put("allTasks",myAllFinishedTask);
        return  jsonObject;
    }
}
