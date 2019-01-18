package school.service;

import school.util.Page;
import school.bean.Issuetask;
import school.bean.Task;

import java.util.List;

/*
*  发布任务服务
* */
public interface IssueTaskService {
    // 获取一个任务根据id
    Issuetask selectOneTask(int id);
    // 获订单信息（分页）
    List<Task> selectTask(Page page);
    // 获取任务按条件查询
    List<Task> selectByWhere(String content,String type);
    // 删除任务
    void deletTask(int id);
    // 修改任务
    int updateTask(Task task);
}
