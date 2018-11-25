package com.school.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Issuetask {
    private Integer id; // 任务编号

    private String request; // 任务要求

    private Integer issueAccount; // 发布者账号

    private Float price; // 任务价格

    private String type; // 任务类型
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date starttime; // 任务开始时间

    private Integer endtime; // 任务需要多少时间

    private Integer accept; // 是否被领取

    private Integer giveup; // 是否放弃

    private Integer finished; // 是否完成

    private String appraise; // 任务评价内容

    private Integer appraiselevel; // 任务评价等级

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public Integer getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(Integer issueAccount) {
        this.issueAccount = issueAccount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getGiveup() {
        return giveup;
    }

    public void setGiveup(Integer giveup) {
        this.giveup = giveup;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise == null ? null : appraise.trim();
    }

    public Integer getAppraiselevel() {
        return appraiselevel;
    }

    public void setAppraiselevel(Integer appraiselevel) {
        this.appraiselevel = appraiselevel;
    }
}