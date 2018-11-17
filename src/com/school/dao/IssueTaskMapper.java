package com.school.dao;

import com.school.bean.IssueTask;

import java.util.List;

public interface IssueTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IssueTask record);

    IssueTask selectByPrimaryKey(Integer id);

    List<IssueTask> selectAll();

    int updateByPrimaryKey(IssueTask record);
}