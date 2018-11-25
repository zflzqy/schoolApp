package com.school.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Receivetask {
    private Integer id; // id

    private Integer receiveaccount; // 领取人账号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishtime; // 完成时间

    private Integer iid; // 任务id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiveaccount() {
        return receiveaccount;
    }

    public void setReceiveaccount(Integer receiveaccount) {
        this.receiveaccount = receiveaccount;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }
}