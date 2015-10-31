package com.github.schedule.task.controller;

import com.github.schedule.task.service.TaskService;
import com.github.schedule.task.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/add")
    public String add(TaskVo taskVo) {
        return "/task/add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(TaskVo taskVo) {
        taskService.add(taskVo);
        return "/task/add";
    }

}
