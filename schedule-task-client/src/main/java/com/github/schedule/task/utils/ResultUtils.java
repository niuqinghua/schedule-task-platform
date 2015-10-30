package com.github.schedule.task.utils;

import com.github.schedule.task.dto.ResultDto;
import com.github.schedule.task.dto.TaskDto;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class ResultUtils {

    public static ResultDto buildSuccessResult(TaskDto taskDto) {
        return new ResultDto(true, taskDto);
    }

    public static ResultDto buildFailResult(TaskDto taskDto) {
        return new ResultDto(false, taskDto);
    }

}
