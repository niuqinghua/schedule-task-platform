package com.github.schedule.task.domain;

import java.util.Date;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class Task extends BaseDomain {

    private String businessId;

    private int type;

    private int retryCount;

    private int retryInterval;

    private int retryLimit;

    private Date retryTime;

    private String content;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(int retryLimit) {
        this.retryLimit = retryLimit;
    }

    public Date getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Date retryTime) {
        this.retryTime = retryTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override public String toString() {
        return "Task{" +
                "businessId='" + businessId + '\'' +
                ", type=" + type +
                ", retryCount=" + retryCount +
                ", retryInterval=" + retryInterval +
                ", retryLimit=" + retryLimit +
                ", retryTime=" + retryTime +
                ", content='" + content + '\'' +
                "} " + super.toString();
    }
}
