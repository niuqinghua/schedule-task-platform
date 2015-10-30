package com.github.schedule.task.service.impl;

import com.github.schedule.task.constants.TaskStatus;
import com.github.schedule.task.dao.FailTaskDao;
import com.github.schedule.task.domain.Task;
import com.github.schedule.task.service.FailTaskService;
import com.github.schedule.task.service.HistoryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by niuqinghua on 15/10/30.
 */
@Service("failTaskService")
public class FailTaskServiceImpl implements FailTaskService {

    @Autowired
    private FailTaskDao failTaskDao;

    @Autowired
    private HistoryTaskService historyTaskService;

    @Override
    public Task getOne() {
        return failTaskDao.getOne();
    }

    @Override
    public Task getByBusinessId(String businessId) {
        return failTaskDao.getByBusinessId(businessId);
    }

    @Override
    public void add(Task task) {
        failTaskDao.add(task);
    }

    @Override
    public int update(Task task) {
        return failTaskDao.update(task);
    }

    @Override
    public int delete(long id) {
        return failTaskDao.delete(id);
    }

    @Override
    public void executeSuccess(Task task) {
        failTaskDao.delete(task.getId());
        task.setStatus(TaskStatus.SUCCESS);
        historyTaskService.add(task);
    }

    @Override
    public void executeFail(Task task) {
        task.setRetryCount(task.getRetryCount() + 1);
        task.setRetryTime(getRetryTimeForFailedTask(task));
        update(task);
    }

    private Date getRetryTimeForFailedTask(Task task) {
        return new Date(task.getRetryTime().getTime() + task.getRetryInterval() * 1000);
    }
}
