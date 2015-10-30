package com.github.schedule.task.service.impl;

import com.github.schedule.task.constants.TaskStatus;
import com.github.schedule.task.dao.TaskDao;
import com.github.schedule.task.domain.Task;
import com.github.schedule.task.service.HistoryTaskService;
import com.github.schedule.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private com.github.schedule.task.service.FailTaskService failTaskService;

    @Autowired
    private HistoryTaskService historyTaskService;

    @Override
    public Task getOne() {
        Task task = taskDao.getOne();
        int affectedCount = updateStatus(task);
        if (affectedCount == 0) {
            return null;
        }
        return task;
    }

    @Override
    public Task getByBusinessId(String businessId) {
        return taskDao.getByBusinessId(businessId);
    }

    @Override
    public int updateStatus(Task task) {
        return taskDao.updateStatus(task);
    }

    @Override
    public int delete(Long id) {
        return taskDao.delete(id);
    }

    @Override
    public void executeSuccess(Task task) {
        delete(task.getId());
        task.setStatus(TaskStatus.SUCCESS);
        historyTaskService.add(task);
    }

    @Override
    public void executeFail(Task task) {
        delete(task.getId());
        task.setRetryTime(getRetryTimeForFirstFailedTask(task));
        failTaskService.add(task);
    }

    private Date getRetryTimeForFirstFailedTask(Task task) {
        return new Date(task.getUpdatedTime().getTime() + task.getRetryInterval() * 1000);
    }
}
