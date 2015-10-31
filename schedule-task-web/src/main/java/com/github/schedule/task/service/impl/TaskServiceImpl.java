package com.github.schedule.task.service.impl;

import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.TaskDubboService;
import com.github.schedule.task.service.TaskService;
import com.github.schedule.task.vo.TaskVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private TaskDubboService taskDubboService;

    @Override public void add(TaskVo taskVo) {
        taskDubboService.add(dozerBeanMapper.map(taskVo, TaskDto.class));
    }

}
