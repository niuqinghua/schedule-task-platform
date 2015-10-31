package com.github.schedule.task.protocol.dubbo;

import com.github.schedule.task.domain.Task;
import com.github.schedule.task.domain.TaskRetryRule;
import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.TaskDubboService;
import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/30.
 */
@Service("taskDubboService")
public class TaskDubboServiceImpl implements TaskDubboService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRetryRuleService taskRetryRuleService;

    @Override
    public TaskDto getOneTask(int type) {
        System.out.println("taskDubboService");
        Task task = taskService.getOne(type);
        if (task == null) {
            return null;
        }
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setBusinessId(task.getBusinessId());
        taskDto.setType(task.getType());
        taskDto.setContent(task.getContent());
        return taskDto;
    }

    @Override
    public void notice(ResultDto resultDto) {
        TaskDto taskDto = resultDto.getTaskDto();
        Task task = taskService.get(taskDto.getId());
        boolean success = resultDto.isSuccess();
        if (success) {
            taskService.executeSuccess(task);
        } else {
            taskService.executeFail(task);
        }
    }

    @Override
    public void add(TaskDto taskDto) {
        int taskType = taskDto.getType();
        TaskRetryRule taskRetryRule = taskRetryRuleService.getByTaskType(taskType);
        if (taskRetryRule != null) {
            Task task = new Task();
            task.setBusinessId(taskDto.getBusinessId());
            task.setContent(taskDto.getContent());
            task.setType(taskDto.getType());
            task.setRetryCount(0);
            task.setRetryInterval(taskRetryRule.getRetryInterval());
            task.setRetryLimit(taskRetryRule.getRetryLimit());
            taskService.add(task);
        }
    }
}
