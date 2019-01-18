package school.service.Impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.bean.*;
import school.dao.IssuetaskMapper;
import school.dao.ReceivetaskMapper;
import school.dao.UserMapper;
import school.service.TaskService;
import school.util.CreditComparator;
import school.util.Datechange;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    IssuetaskMapper issuetaskMapper;
    @Autowired
    ReceivetaskMapper receivetaskMapper;
    @Autowired
    UserMapper userMapper;
    // 我的任务
    @Override
    public List<Task> getTaskByIssueaccont(int account) {
        List<Task> tasks = new ArrayList<>();
        // 获取发布任务信息
        List<Issuetask> issuetasks = issuetaskMapper.selectIssueTaskByAccount(account);
        // 循环获取对应任务的领取信息并构造task
        Task task = null;
        for (Issuetask issuetask:issuetasks){
            task = new Task();
            // 获取领取任务信息
            Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
            // 构造taskk
            tasks.add(getTask(issuetask,receivetask));
        }
        return tasks;
    }
    // 发布任务
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int addTast(String taskStr) {
        int row =0;
        // 1.添加发布任务信息
        Task task = JSONObject.parseObject(taskStr,Task.class);
        System.out.printf(task.toString());
        Issuetask issuetask = JSONObject.parseObject(taskStr,Issuetask.class);
        // 部分字段设计未能填充上
        issuetask.setIssueAccount(task.getIssue_account());
        System.out.printf(issuetask.toString());
        // 插入的主键id将重新返回到task中
        row+=issuetaskMapper.insert(issuetask);
        // 2.添加接收任务信息
        row +=receivetaskMapper.insertOneRecevie(issuetask.getId());
        return row;
    }
    // 他人所有的任务
    @Override
    public List<Task> getAllTask(int account) {
        List<Task> tasks = new ArrayList<>();
        // 先获取发布人的学校
        User user = userMapper.selectByAccount(account);
        // 获取发布任务信息
        List<Issuetask> issuetasks = issuetaskMapper.selectIssueTaskNotMe(account);
        // 循环获取对应任务的领取信息并构造task
        Task task = null;
        List<Task> temptasks = new ArrayList<>();
        for (Issuetask issuetask:issuetasks){
            task = new Task();
            // 筛选符合条件的
            String school = userMapper.selectByAccount(issuetask.getIssueAccount()).getSchool();
            if (school.equals(user.getSchool())){
                // 如果学校相同
                // 获取领取任务信息
                Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
                // 构造taskk
                temptasks.add(getTask(issuetask,receivetask));
            }
        }
        // 信用排序
        List<Credit> credits = new ArrayList<>();
        // 1.先查询信用
        Credit credit = null;
        for (Task t:temptasks){
            credit = new Credit();
            // 查询所有的信用
            credit.setCredit(userMapper.selectByAccount(t.getIssue_account()).getCredit());
            credit.setTid(t.getId());
            credits.add(credit);
        }
        // 2.排序
        Collections.sort(credits,new CreditComparator());
        // 将排序好的重新添加进入
        for (Credit c:credits){
            for (Task t:temptasks){
                if (c.getTid()==t.getId()){
                    tasks.add(t);
                    break;
                }
            }// 内层循环
        }

        return tasks;
    }
    // 放弃我的任务
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int giveupMyTask(String taskStr) {
        int row =0;
        // 1.放弃发布任务信息
        Issuetask issuetask = JSONObject.parseObject(taskStr,Issuetask.class);
        // 将任务的属性设置为放弃
        row =issuetaskMapper.giveupTask(issuetask);
        return row;
    }
    // 领取任务
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int receiveTask(String taskStr) {
        int row =0;
        Task task = JSONObject.parseObject(taskStr,Task.class);
        // 1.领取发布任务
        Issuetask issuetask = JSONObject.parseObject(taskStr,Issuetask.class);
        // 将任务的属性设置为领取
        row +=issuetaskMapper.recevieTask(issuetask);
        // 领取信息构造领取信息
        Receivetask receivetask = new Receivetask();
        receivetask.setIid(task.getId());
        receivetask.setReceiveaccount(task.getReceive_account());
        row +=receivetaskMapper.recevieTask(receivetask);
        return row;
    }
    // 已领任务
    @Override
    public List<Task> gethaveReceiveTask(int account) {
        // 获取所有已领任务，不包含放弃和完成的
        List<Task> tasks = new ArrayList<>();
        // 1.获取所有我领取的任务
        List<Receivetask> receivetasks = receivetaskMapper.selectReceivetask(account);
        Task task = null;
        for (Receivetask receivetask:receivetasks){
            task = new Task();
            Issuetask issuetask = issuetaskMapper.selectByPrimaryKey(receivetask.getIid());
            // 2.筛选符合条件的
            if (issuetask.getGiveup()==0&&issuetask.getFinished()==0){
                tasks.add(getTask(issuetask,receivetask));
            }
        }
        return tasks;
    }
    // 完成任务
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int finishedTask(String taskStr) {
        int row =0;
        // 更改任务属性
        Issuetask issuetask = JSONObject.parseObject(taskStr,Issuetask.class);
        row += issuetaskMapper.finishedTask(issuetask);
        // 增加完成时间
        Receivetask receivetask = JSONObject.parseObject(taskStr,Receivetask.class);
        receivetask.setIid(issuetask.getId());
        receivetask.setFinishtime(new Date());
        row +=receivetaskMapper.updateFinishedTimeTask(receivetask);
        return row;
    }
    // 修改任务完成状态
    @Override
    public int finishedTaskStatus(Issuetask issuetask) {
        int row =0;
        // 更改任务属性
        row += issuetaskMapper.finishedTask(issuetask);
        return row;
    }

    // 获取我的异常任务
    @Override
    public List<Task> getMyExceptionTask(int account) {
        List<Task> tasks = new ArrayList<>();
        // 首先获取我发布的异常
        List<Issuetask> issuetasks = issuetaskMapper.selectMyException(account);
        // 构造task
        for (Issuetask issuetask:issuetasks){
            Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
            tasks.add(getTask(issuetask,receivetask));
        }
        // 获取我领取的异常
        // 1.首先获取我的所有领取的任务
        List<Receivetask> receivetasks = receivetaskMapper.selectReceivetask(account);
        // 2.筛选符合条件的
        for (Receivetask receivetask:receivetasks){
            Issuetask issuetask = issuetaskMapper.selectByPrimaryKey(receivetask.getIid());
            if (issuetask.getGiveup()!=0){
                tasks.add(getTask(issuetask,receivetask));
            }
        }
        return tasks;
    }
    // 获取待评价任务
    @Override
    public List<Task> getMyAppriseTask(int account) {
        List<Task> tasks = new ArrayList<>();
        // 1.获取待评价任务
        List<Issuetask> issuetasks = issuetaskMapper.selectMyApprise(account);
        // 2.构造task
        for (Issuetask issuetask:issuetasks){
            Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
            tasks.add(getTask(issuetask,receivetask));
        }
        return tasks;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int appriseTask(String taskStr) {
        // 评价任务
        Issuetask issuetask = JSONObject.parseObject(taskStr,Issuetask.class);
        // 评价任务
        int row = issuetaskMapper.appriaseTaskAppriase(issuetask);
        return row;
    }

    // 获取待付款任务
    @Override
    public List<Task> getMyPayTask(int account) {
        // 1.返回的结果集
        List<Task> tasks = new ArrayList<>();
        List<Issuetask> issuetasks = issuetaskMapper.selectMyPay(account);
        for (Issuetask issuetask:issuetasks){
            Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
            tasks.add(getTask(issuetask,receivetask));
        }
        return tasks;
    }
    // 获取图片
    @Override
    public File getUserFile(int account) {
        User user = userMapper.selectByAccount(account);
        File file = new File(user.getPath());
        return file;
    }

    // 获取所有已完成任务
    @Override
    public List<Task> getMyAllFinishedTask(int account) {
        List<Task> tasks = new ArrayList<>();
        // 1.获取自己发布的完成的
        List<Issuetask> myFinishedTask = issuetaskMapper.selectMyFinished(account);
        // 1.1获取完成人信息
        for (Issuetask issuetask:myFinishedTask){
            Receivetask receivetask = receivetaskMapper.selectByIid(issuetask.getId());
            tasks.add(getTask(issuetask,receivetask));
        }
        // 2.获取别人发布（自己领取的）的完成的
        // 2.2先获取所有自己领取的
        List<Receivetask> myReceiveTask= receivetaskMapper.selectReceivetask(account);
        // 2.3获取任务主体信息
        for (Receivetask receivetask:myReceiveTask){
            Issuetask issuetask = issuetaskMapper.selectByPrimaryKey(receivetask.getIid());
            // 筛选符合条件的
            if (issuetask.getFinished()!=0){
                tasks.add(getTask(issuetask,receivetask));
            }
        }
        return tasks;
    }


    // 构造task
    private Task getTask(Issuetask issuetask,Receivetask receivetask){
        Task task = new Task();
        // 任务要求
        task.setRequest(issuetask.getRequest());
        // 任务类型
        task.setType(issuetask.getType());
        // 任务价格
        task.setPrice(issuetask.getPrice());
        // 发布者账号
        task.setIssue_account(issuetask.getIssueAccount());
        // 任务id
        task.setId(issuetask.getId());
        // 任务放弃状态
        task.setGiveup(issuetask.getGiveup());
        // 任务完成状态
        task.setFinished(issuetask.getFinished());
        // 任务需要多少时间
        task.setEndtime(issuetask.getEndtime());
        // 任务评价等级
        task.setAppraiselevel(issuetask.getAppraiselevel());
        // 任务评价内容
        task.setAppraise(issuetask.getAppraise());
        // 任务接受状态
        task.setAccept(issuetask.getAccept());
        // 任务开始时间
        if (issuetask.getStarttime()!=null){
            task.setStarttime(Datechange.dateToString(issuetask.getStarttime()));
        }
        // 领取信息
        if (receivetask!=null){
            // 领取人账号
            if (receivetask.getReceiveaccount()!=null) {
                task.setReceive_account(receivetask.getReceiveaccount());
            }
            // 完成时间
            if (receivetask.getFinishtime()!=null){
            task.setFinishtime(Datechange.dateToString(receivetask.getFinishtime()));
            }
        }
        return  task;
    }

}
