package com.github.schedule.task.executor;

import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.TaskDubboService;
import com.github.schedule.task.utils.ResultUtils;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class NormalTaskExecutor extends AbstractJobExecutor {

    private TaskDubboService taskDubboService;

    @Override
    protected TaskDto getOneTask(int type) {
        return taskDubboService.getOneTask(type);
    }

    @Override
    protected void executeSuccess(TaskDto task) {
        taskDubboService.notice(ResultUtils.buildSuccessResult(task));
    }

    @Override
    protected void executeFail(TaskDto task) {
        taskDubboService.notice(ResultUtils.buildFailResult(task));
    }

    public void setTaskDubboService(TaskDubboService taskDubboService) {
        this.taskDubboService = taskDubboService;
    }
}
