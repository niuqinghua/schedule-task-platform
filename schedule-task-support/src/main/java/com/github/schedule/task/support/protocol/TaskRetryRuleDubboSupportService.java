package com.github.schedule.task.support.protocol;

import com.github.schedule.task.support.dto.PageParameterDto;
import com.github.schedule.task.support.dto.PageResultDto;
import com.github.schedule.task.support.dto.TaskRetryRuleDto;

/**
 * Created by niuqinghua on 15/10/31.
 */
public interface TaskRetryRuleDubboSupportService {

    void add(TaskRetryRuleDto taskRetryRuleDto);

    void update(TaskRetryRuleDto taskRetryRuleDto);

    void delete(long id);

    TaskRetryRuleDto get(long id);

    PageResultDto<TaskRetryRuleDto> find(PageParameterDto pageParameterDto);

}
