package com.school.dao;

import com.school.bean.Receivetask;
import java.util.List;

public interface ReceivetaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Receivetask record);

    Receivetask selectByPrimaryKey(Integer id);

    List<Receivetask> selectAll();

    int updateByPrimaryKey(Receivetask record);
}