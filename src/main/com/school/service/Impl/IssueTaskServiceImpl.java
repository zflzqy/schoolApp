package school.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.bean.Issuetask;
import school.bean.Receivetask;
import school.bean.Task;
import school.constant.TaskConstant;
import school.dao.IssuetaskMapper;
import school.dao.ReceivetaskMapper;
import school.service.IssueTaskService;
import school.util.Datechange;
import school.util.Page;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueTaskServiceImpl implements IssueTaskService {
    @Autowired
    IssuetaskMapper issuetaskMapper;
    @Autowired
    ReceivetaskMapper receivetaskMapper;

    @Override
    public Issuetask selectOneTask(int id) {
        return issuetaskMapper.selectByPrimaryKey(id);
    }

    // 获取任务
    @Override
    public List<Task> selectTask(Page page) {
        List<Task> tasks = new ArrayList<>();
        Task task;
        // 查询发布的任务详细信息
        List<Issuetask> issuetasks = issuetaskMapper.selectIssueTask(page);
        // 得到总数
        int total = issuetaskMapper.total();
        // 计算最后一页
        page.getLastLocation(total);
        // 循环写入tasks
        for (Issuetask t:issuetasks){
            // 根据发布任务id查询领取信息
            Receivetask receivetask =receivetaskMapper.selectByIid(t.getId());
            // 将两者信息填充到task中
            task = new Task();
            // 填充到list容器中
            tasks.add(getTask(t,receivetask));
        }

        return tasks;
    }
    // 获取任务按条件查询
    @Override
    public List<Task> selectByWhere(String content,String type) {
        List<Task> tasks = new ArrayList<>();
        // 查询任务(通过任务的条件)
        List<Issuetask> issuetasks = null;
        List<Receivetask> receivetasks= null;
        if (!type.equals(TaskConstant.RECEIVECOUNT)){
            // 先查issue表
            try {
                // 捕获数据转换异常
                if (type.equals(TaskConstant.ACCOUNT)) {
                    issuetasks = issuetaskMapper.selectByWhere(0, Integer.parseInt(content), null, 0);
                }else  if (type.equals(TaskConstant.TASKID)){
                    issuetasks = issuetaskMapper.selectByWhere(Integer.parseInt(content), 0, null, 0);
                }else if (type.equals(TaskConstant.PRICE)){
                    issuetasks = issuetaskMapper.selectByWhere(0, 0, null, Float.parseFloat(content));
                }else if (type.equals(TaskConstant.TYPE)){
                    issuetasks = issuetaskMapper.selectByWhere(0, 0, content, 0);
                }
            }catch (Exception e){
                return tasks;
            }
            // 查receive表
            if (issuetasks==null){
                return tasks; // 如果没有直接返回
            }else {
                // 如果有查询领取人信息
                for (Issuetask issuetask:issuetasks){
                    Task task = getTask(issuetask,receivetaskMapper.selectByIid(issuetask.getId()));
                    tasks.add(task);
                }
            }
        }else {
            // 先查rece表
            List<Receivetask> reces = receivetaskMapper.selectReceivetask(Integer.parseInt(content));
            if (reces==null){
                // 如果没有的话
                return tasks;
            }else {
                // 有的话
                for (Receivetask receivetask:reces){
                    Task task = getTask(issuetaskMapper.selectByPrimaryKey(receivetask.getIid()),receivetask);
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }
    // 删除任务

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deletTask(int id){
        // 删除task
        issuetaskMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public int updateTask(Task task){
        // 修改任务
        Issuetask issuetask = new Issuetask();
        // 设置issuetask 相关属性
        issuetask.setId(task.getId());
        issuetask.setAppraise(task.getAppraise());
        issuetask.setAppraiselevel(task.getAppraiselevel());
        int row = issuetaskMapper.updateTaskAppriase(issuetask);
        return row;
    }
    // 生成task根据issue和receive
    private Task getTask(Issuetask issuetask,Receivetask receivetask){
        Task task = new Task();
        // 填充任务信息
        task.setAccept(issuetask.getAccept());
        task.setAppraise(issuetask.getAppraise());
        task.setAppraiselevel(issuetask.getAppraiselevel());
        task.setEndtime(issuetask.getEndtime());
        task.setFinished(issuetask.getFinished());
        task.setGiveup(issuetask.getGiveup());
        task.setId(issuetask.getId());
        task.setIssue_account(issuetask.getIssueAccount());
        task.setPrice(issuetask.getPrice());
        task.setRequest(issuetask.getRequest());
        if (issuetask.getStarttime()!=null){
            task.setStarttime(Datechange.dateToString(issuetask.getStarttime()));
        }
        task.setType(issuetask.getType());
        // 填充领取信息
        if (receivetask==null){
            // 如果为空则不填充
        }else {
            if (receivetask.getReceiveaccount()!=null){
                task.setReceive_account(receivetask.getReceiveaccount());
            }
            if (receivetask.getFinishtime()!=null){
                task.setFinishtime(Datechange.dateToString(receivetask.getFinishtime()));
            }


        }
        return task;
    }
}
