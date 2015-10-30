package com.github.schedule.task.service;

import com.github.schedule.task.domain.Task;

/**
 * Created by niuqinghua on 15/10/28.
 */
public interface FailTaskService {

    Task getOne();

    Task getByBusinessId(String businessId);

    void add(Task task);

    int update(Task task);

    int delete(long id);

    void executeSuccess(final Task task);

    void executeFail(final Task task);

}
