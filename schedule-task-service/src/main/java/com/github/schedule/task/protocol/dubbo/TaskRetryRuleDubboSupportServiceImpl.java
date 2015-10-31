package com.github.schedule.task.protocol.dubbo;

import com.github.schedule.task.domain.TaskRetryRule;
import com.github.schedule.task.service.TaskRetryRuleService;
import com.github.schedule.task.support.dto.PageParameterDto;
import com.github.schedule.task.support.dto.PageResultDto;
import com.github.schedule.task.support.dto.TaskRetryRuleDto;
import com.github.schedule.task.support.protocol.TaskRetryRuleDubboSupportService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niuqinghua on 15/10/31.
 */
@Service("taskRetryRuleDubboSupportService")
public class TaskRetryRuleDubboSupportServiceImpl implements TaskRetryRuleDubboSupportService {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private TaskRetryRuleService taskRetryRuleService;

    @Override
    public void add(TaskRetryRuleDto taskRetryRuleDto) {
        taskRetryRuleService.add(dozerBeanMapper.map(taskRetryRuleDto, TaskRetryRule.class));
    }

    @Override
    public void update(TaskRetryRuleDto taskRetryRuleDto) {
        taskRetryRuleService.update(dozerBeanMapper.map(taskRetryRuleDto, TaskRetryRule.class));
    }

    @Override
    public void delete(long id) {
        taskRetryRuleService.delete(id);
    }

    @Override
    public TaskRetryRuleDto get(long id) {
        TaskRetryRule taskRetryRule = taskRetryRuleService.get(id);

        if (taskRetryRule == null) {
            return null;
        }

        return dozerBeanMapper.map(taskRetryRule, TaskRetryRuleDto.class);
    }

    @Override
    public PageResultDto<TaskRetryRuleDto> find(PageParameterDto pageParameterDto) {
        return null;
    }
}
