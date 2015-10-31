package com.github.schedule.task.service.impl;

import com.github.schedule.task.dao.TaskRetryRuleDao;
import com.github.schedule.task.domain.PageParameter;
import com.github.schedule.task.domain.PageResult;
import com.github.schedule.task.domain.TaskRetryRule;
import com.github.schedule.task.service.TaskRetryRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Service("taskRetryRuleService")
public class TaskRetryRuleServiceImpl implements TaskRetryRuleService {

    @Autowired
    private TaskRetryRuleDao taskRetryRuleDao;

    @Override
    public void add(TaskRetryRule taskRetryRule) {
        taskRetryRuleDao.add(taskRetryRule);
    }

    @Override
    public void update(TaskRetryRule taskRetryRule) {
        taskRetryRuleDao.update(taskRetryRule);
    }

    @Override
    public void delete(long id) {
        taskRetryRuleDao.delete(id);
    }

    @Override
    public TaskRetryRule get(long id) {
        return taskRetryRuleDao.get(id);
    }

    @Override
    public TaskRetryRule getByTaskType(int taskType) {
        return taskRetryRuleDao.getByTaskType(taskType);
    }

    @Override
    public PageResult<TaskRetryRule> find(PageParameter pageParameter) {
        return null;
    }

}
