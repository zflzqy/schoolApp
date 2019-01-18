package school.dao;

import school.bean.Receivetask;

import java.util.List;

public interface ReceivetaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Receivetask record);

    Receivetask selectByPrimaryKey(Integer id);

    List<Receivetask> selectAll();

    int updateByPrimaryKey(Receivetask record);
    // 根据用户账号查询领取量
    int selectReceiveCountByAcount(int account);
    // 查询任务的领取状况根据任务id
    Receivetask selectByIid(int iid);
    // 根据领取账号查询
    List<Receivetask> selectReceivetask(int receiveaccount);
    // 添加任务时插入一个空的领取任务
    int insertOneRecevie(int iid);
    // 领取任务
    int recevieTask(Receivetask receivetask);
    // 增加完成任务时间
    int updateFinishedTimeTask(Receivetask receivetask);
}