package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.school.bean.Task;
import com.school.service.IssueTaskService;
import com.school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
// 订单管理控制器
public class TaskController {
    @Autowired
    IssueTaskService issueTaskService;
    // 获取任务信息
    @RequestMapping("/taskManager")
    @ResponseBody
    public JSONObject orderMannager(Page taskPage){
        JSONObject jsonObject = new JSONObject();
        List<Task> tasks = issueTaskService.selectTask(taskPage);
        if (tasks.size()!=0){
            jsonObject.put("tasks",tasks);
            jsonObject.put("tasklast",taskPage.getLast());
        }else {
            return  null;
        }
        return jsonObject;
    }
    // 按条件查询
    @RequestMapping("/searchByRequired")
    @ResponseBody
    public JSONObject searchByRequired(String content,String type){
        JSONObject jsonObject = new JSONObject();
        // service层操作
        List<Task> tasks = issueTaskService.selectByWhere(content,type);
        if (tasks.size()!=0){
            System.out.println(tasks.size());
            for (Task task:tasks){
                System.out.println("controller"+task.getStarttime());
            }
            jsonObject.put("tasks",tasks);
        }else {
            return null;
        }
        return  jsonObject;
    }
    // 删除任务
    @RequestMapping("/deletTask")
    @ResponseBody
    public void deletTask(int id){
        issueTaskService.deletTask(id);
    }
    // 修改任务
    @RequestMapping("/updateTask")
    @ResponseBody()
    public JSONObject updateTask(Task task){
        JSONObject jsonObject = new JSONObject();
        System.out.println(task.toString());
        int row = issueTaskService.updateTask(task);
        if (row==0){
            return  null;
        }
        return  jsonObject;
    }
}
