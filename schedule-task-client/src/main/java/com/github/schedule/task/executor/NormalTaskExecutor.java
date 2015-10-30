package com.github.schedule.task.executor;

import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.TaskService;
import com.github.schedule.task.utils.ResultUtils;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class NormalTaskExecutor extends AbstractJobExecutor {

    private TaskService taskService;

    @Override
    protected TaskDto getOneTask(int type) {
        return taskService.getOneTask(type);
    }

    @Override
    protected void executeSuccess(TaskDto task) {
        taskService.notice(ResultUtils.buildSuccessResult(task));
    }

    @Override
    protected void executeFail(TaskDto task) {
        taskService.notice(ResultUtils.buildFailResult(task));
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
