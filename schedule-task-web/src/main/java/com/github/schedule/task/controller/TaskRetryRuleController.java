package com.github.schedule.task.controller;

import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.vo.TaskRetryRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Controller
@RequestMapping(value = "/task/retry/rule")
public class TaskRetryRuleController {

    @Autowired
    private TaskRetryRuleService taskRetryRuleService;

    @RequestMapping(value = "/add")
    public String add() {
        return "/task/retry/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(TaskRetryRuleVo taskRetryRuleVo) {
        taskRetryRuleService.add(taskRetryRuleVo);
        return "/task/retry/add";
    }

}
