package com.github.schedule.task.service.impl;

import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.support.dto.TaskRetryRuleDto;
import com.github.schedule.task.support.protocol.TaskRetryRuleDubboSupportService;
import com.github.schedule.task.vo.TaskRetryRuleVo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Service("taskRetryRuleService")
public class TaskRetryRuleServiceImpl implements TaskRetryRuleService {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private TaskRetryRuleDubboSupportService taskRetryRuleDubboSupportService;

    @Override public void add(TaskRetryRuleVo taskRetryRuleVo) {
        taskRetryRuleDubboSupportService.add(dozerBeanMapper.map(taskRetryRuleVo, TaskRetryRuleDto.class));
    }

}
