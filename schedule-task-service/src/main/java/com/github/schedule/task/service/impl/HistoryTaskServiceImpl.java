package com.github.schedule.task.service.impl;

import com.github.schedule.task.dao.HistoryTaskDao;
import com.github.schedule.task.domain.Task;
import com.github.schedule.task.service.HistoryTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/30.
 */
@Service("historyTaskService")
public class HistoryTaskServiceImpl implements HistoryTaskService {

    @Autowired
    private HistoryTaskDao historyTaskDao;

    @Override
    public void add(Task task) {
        historyTaskDao.add(task);
    }
}
