package com.github.schedule.task.domain;

/**
 * Created by niuqinghua on 15/10/31.
 */
public class TaskRetryRule extends BaseDomain {

    private int taskType;

    private int retryInterval;

    private int retryLimit;

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
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

    @Override
    public String toString() {
        return "TaskRetryRule{" +
                "taskType=" + taskType +
                ", retryInterval=" + retryInterval +
                ", retryLimit=" + retryLimit +
                "} " + super.toString();
    }
}
