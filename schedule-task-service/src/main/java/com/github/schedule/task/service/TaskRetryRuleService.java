package com.github.schedule.task.service;

import com.github.schedule.task.domain.PageParameter;
import com.github.schedule.task.domain.PageResult;
import com.github.schedule.task.domain.TaskRetryRule;

/**
 * Created by niuqinghua on 15/10/31.
 */
public interface TaskRetryRuleService {

    void add(TaskRetryRule taskRetryRule);

    void update(TaskRetryRule taskRetryRule);

    void delete(long id);

    TaskRetryRule get(long id);

    TaskRetryRule getByTaskType(int taskType);

    PageResult<TaskRetryRule> find(PageParameter pageParameter);

}
