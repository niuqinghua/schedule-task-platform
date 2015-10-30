package com.github.schedule.task.service;

import com.github.schedule.task.domain.Task;

/**
 * Created by niuqinghua on 15/10/28.
 */
public interface TaskService {

    Task getOne(int type);

    Task get(long id);

    int updateStatus(Task task);

    int delete(Long id);

    void executeSuccess(final Task task);

    void executeFail(final Task task);

}
