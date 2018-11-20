package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.school.bean.Task;
import com.school.service.TaskService;
import com.school.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
// 订单管理控制器
public class TaskManager {
    @Autowired
    TaskService taskService;
    // 获取任务信息
    @RequestMapping("/taskManager")
    @ResponseBody
    public JSONObject orderMannager(Page taskPage){
        JSONObject jsonObject = new JSONObject();
        List<Task> tasks = taskService.selectTask(taskPage);
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
        List<Task> tasks = taskService.selectByWhere(content,type);
        if (tasks.size()!=0){
            jsonObject.put("tasks",tasks);
        }else {
            return null;
        }
        return  jsonObject;
    }
}
