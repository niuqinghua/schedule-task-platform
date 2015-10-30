package com.github.schedule.task.dto;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class ResultDto {

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
