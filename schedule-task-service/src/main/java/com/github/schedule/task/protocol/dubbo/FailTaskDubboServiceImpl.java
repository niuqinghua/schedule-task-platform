package com.github.schedule.task.protocol.dubbo;

import com.github.schedule.task.domain.Task;
import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;
import com.github.schedule.task.protocol.FailTaskDubboService;
import com.github.schedule.task.service.FailTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/30.
 */
@Service("failTaskDubboService")
public class FailTaskDubboServiceImpl implements FailTaskDubboService {

    @Autowired
    private FailTaskService failTaskService;

    @Override
    public TaskDto getOneTask(int type) {
        System.out.println("failTaskDubboService");
        Task task = failTaskService.getOne(type);
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

    @Override public void notice(ResultDto resultDto) {
        TaskDto taskDto = resultDto.getTaskDto();
        Task task = failTaskService.get(taskDto.getId());
        boolean success = resultDto.isSuccess();
        if (success) {
            failTaskService.executeSuccess(task);
        } else {
            failTaskService.executeFail(task);
        }
    }
}
