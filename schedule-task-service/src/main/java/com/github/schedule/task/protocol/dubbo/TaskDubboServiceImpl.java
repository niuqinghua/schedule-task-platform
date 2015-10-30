package com.github.schedule.task.protocol.dubbo;

import com.github.schedule.task.domain.Task;
import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.TaskDubboService;
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
}
