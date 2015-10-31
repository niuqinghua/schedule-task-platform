package com.github.schedule.task.protocol.dubbo;

import com.github.schedule.task.domain.Task;
import com.github.schedule.task.domain.TaskRetryRule;
import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.service.TaskService;
import com.github.schedule.task.support.protocol.TaskDubboSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Service("taskDubboSupportService")
public class TaskDubboSupportServiceImpl implements TaskDubboSupportService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRetryRuleService taskRetryRuleService;

    @Override
    public void add(TaskDto taskDto) {
        int taskType = taskDto.getType();
        TaskRetryRule taskRetryRule = taskRetryRuleService.getByTaskType(taskType);
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
