package com.school.bean;

import java.util.Date;

public class Receivetask {
    private Integer id; // id

    private Integer receiveaccount; // 领取人账号

    private Date finishtime; // 完成时间

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
}