package com.github.schedule.task.executor;

import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.FailTaskDubboService;
import com.github.schedule.task.utils.ResultUtils;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class FailTaskExecutor extends AbstractJobExecutor {

    private FailTaskDubboService failTaskDubboService;

    @Override
    protected TaskDto getOneTask(int type) {
        return failTaskDubboService.getOneTask(type);
    }

    @Override
    protected void executeSuccess(TaskDto task) {
        failTaskDubboService.notice(ResultUtils.buildSuccessResult(task));
    }

    @Override
    protected void executeFail(TaskDto task) {
        failTaskDubboService.notice(ResultUtils.buildFailResult(task));
    }

    public void setFailTaskDubboService(FailTaskDubboService failTaskDubboService) {
        this.failTaskDubboService = failTaskDubboService;
    }
}
