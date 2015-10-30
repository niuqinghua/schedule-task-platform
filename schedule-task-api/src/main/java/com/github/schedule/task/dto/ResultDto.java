package com.github.schedule.task.dto;

import java.io.Serializable;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class ResultDto implements Serializable {

    private boolean success;

    private TaskDto taskDto;

    public ResultDto() {
    }

    public ResultDto(boolean success, TaskDto taskDto) {
        this.success = success;
        this.taskDto = taskDto;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TaskDto getTaskDto() {
        return taskDto;
    }

    public void setTaskDto(TaskDto taskDto) {
        this.taskDto = taskDto;
    }
}
