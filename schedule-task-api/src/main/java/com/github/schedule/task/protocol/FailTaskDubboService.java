package com.github.schedule.task.protocol;

import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;

/**
 * Created by niuqinghua on 15/10/30.
 */
public interface FailTaskDubboService {

    TaskDto getOneTask(int type);

    void notice(ResultDto resultDto);

}
