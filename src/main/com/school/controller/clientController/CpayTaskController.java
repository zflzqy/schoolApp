package school.controller.clientController;

import com.alibaba.fastjson.JSONObject;
import school.bean.Issuetask;
import school.bean.Task;
import school.service.IssueTaskService;
import school.service.TaskService;
import school.util.ImageToUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("")
public class CpayTaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    IssueTaskService issueTaskService;
    // 获取待付款任务
    @RequestMapping("/getPayTask")
    @ResponseBody
    public JSONObject getPayTask(int account){
        JSONObject jsonObject = new JSONObject();
        List<Task> myPayTask = taskService.getMyPayTask(account);
        jsonObject.put("allTasks",myPayTask);
        return  jsonObject;
    }
    // 获取用户图片url(图片可能解析不成功，与图片有关)
    @RequestMapping("/getUserPayImage")
    @ResponseBody
    public JSONObject getUserPayImage(int account,int tid, HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        // 1.取得文件
        File userFile = taskService.getUserFile(account);
        // 2.解析图片成url
        userFile.getAbsolutePath();
        String url = ImageToUrl.testDecode(userFile.getAbsolutePath());
        jsonObject.put("pic",url);
        // 修改任务状态
        // 1.获取任务
        Issuetask issuetask = issueTaskService.selectOneTask(tid);
        // 修改任务
        issuetask.setFinished(2);
        taskService.finishedTaskStatus(issuetask);
        System.out.println("付款url"+url);
        return  jsonObject;
    }
}
