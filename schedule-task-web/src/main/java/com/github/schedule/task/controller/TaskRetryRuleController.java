package com.github.schedule.task.controller;

import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.vo.TaskRetryRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuqinghua on 15/10/31.
 */
@RestController
@RequestMapping(value = "/task/retry/rule")
public class TaskRetryRuleController {

    @Autowired
    private TaskRetryRuleService taskRetryRuleService;

    @RequestMapping(value = "/add/{type}")
    public void add(@PathVariable("type") int type) {
        TaskRetryRuleVo taskRetryRuleVo = new TaskRetryRuleVo();
        taskRetryRuleVo.setTaskType(type);
        taskRetryRuleVo.setRetryLimit(10);
        taskRetryRuleVo.setRetryInterval(60);
        taskRetryRuleVo.setStatus(1);
        taskRetryRuleService.add(taskRetryRuleVo);
    }

}
