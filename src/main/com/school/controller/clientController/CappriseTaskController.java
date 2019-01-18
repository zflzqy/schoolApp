package school.controller.clientController;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import school.bean.Task;
import school.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("")
public class CappriseTaskController {
    @Autowired
    TaskService taskService;
    // 获取待评价任务
    @RequestMapping("/getAppriseTask")
    @ResponseBody
    public JSONObject getAppriseTask(int account){
        JSONObject jsonObject = new JSONObject();
        List<Task> myAppriseTask = taskService.getMyAppriseTask(account);
        jsonObject.put("allTasks",myAppriseTask);
        return  jsonObject;
    }
    // 评价任务
    @RequestMapping("/appriseTask")
    @ResponseBody
    public JSONObject appriseTask(String  task){
        JSONObject jsonObject = new JSONObject();
        int row = taskService.appriseTask(task);
        if (row==0){
            // 评价不成功
            jsonObject.put("tasks","");
        }
        // 评价成功
        jsonObject.put("tasks","APPRISE");
        return  jsonObject;
    }
}
