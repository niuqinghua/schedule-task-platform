package com.github.schedule.task.controller;

import com.github.schedule.task.service.TaskService;
import com.github.schedule.task.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuqinghua on 15/10/31.
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/add/${businessId}")
    public void add(@PathVariable("businessId") String businessId) {
        TaskVo taskVo = new TaskVo();
        taskVo.setBusinessId(businessId);
        taskVo.setContent("test");
        taskVo.setType(1);
        taskService.add(taskVo);
    }

}
