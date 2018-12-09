package com.school.service;

import com.school.bean.Task;
import com.school.util.Page;

import java.util.List;

/*
*  发布任务服务
* */
public interface IssueTaskService {
    // 获订单信息（分页）
    List<Task> selectTask(Page page);
    // 获取任务按条件查询
    List<Task> selectByWhere(String content,String type);
    // 删除任务
    void deletTask(int id);
    // 修改任务
    int updateTask(Task task);
}
