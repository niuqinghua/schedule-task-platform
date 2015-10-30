package com.github.schedule.task.executor;

import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.service.FailTaskService;
import com.github.schedule.task.utils.ResultUtils;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class FailTaskExecutor extends AbstractJobExecutor {

    private FailTaskService failTaskService;

    @Override
    protected TaskDto getOneTask(int type) {
        return failTaskService.getOneTask(type);
    }

    @Override
    protected void executeSuccess(TaskDto task) {
        failTaskService.notice(ResultUtils.buildSuccessResult(task));
    }

    @Override
    protected void executeFail(TaskDto task) {
        failTaskService.notice(ResultUtils.buildFailResult(task));
    }

    public void setFailTaskService(FailTaskService failTaskService) {
        this.failTaskService = failTaskService;
    }
}
