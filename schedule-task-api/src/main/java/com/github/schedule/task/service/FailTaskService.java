package com.github.schedule.task.service;

import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;

/**
 * Created by niuqinghua on 15/10/30.
 */
public interface FailTaskService {

    TaskDto getOneTask(int type);

    void notice(ResultDto resultDto);

}
