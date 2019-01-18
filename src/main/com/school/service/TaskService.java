package school.service;

import school.bean.Issuetask;
import school.bean.Task;

import java.io.File;
import java.util.List;

/*
*  任务----》客户端
* */
public interface TaskService {
    /*
    *  虽然是task的bean但是由于部分字段跟issue一致，所以可以成功转换
    * */
    // 通过账号获取发布的任务
    List<Task> getTaskByIssueaccont(int account);
    // 发布任务
    int addTast(String taskStr);
    // 获取所有非自己发布的任务(未被领取的)
    List<Task> getAllTask(int account);
    // 放弃任务
    int giveupMyTask(String taskStr);
    // 领取任务
    int receiveTask(String taskStr);
    // 已领任务
    List<Task> gethaveReceiveTask(int account);
    // 完成任务
    int finishedTask(String taskStr);
    // 修改任务完成状态
    int finishedTaskStatus(Issuetask issuetask);
    // 获取异常任务
    List<Task> getMyExceptionTask(int account);
    // 获取待评价任务
    List<Task> getMyAppriseTask(int account);
    // 评价任务
    int appriseTask(String taskStr);
    // 获取待付款任务
    List<Task> getMyPayTask(int account);
    // 获取图片
    File getUserFile(int account);
    // 获取已完成任务
    List<Task> getMyAllFinishedTask(int account);
}
