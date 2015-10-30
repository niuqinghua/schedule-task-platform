package com.github.schedule.task.executor;

import com.github.schedule.task.dto.TaskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by niuqinghua on 15/10/30.
 */
abstract public class AbstractJobExecutor implements JobExecutor {

    private static final Logger logger = LoggerFactory.getLogger(AbstractJobExecutor.class);

    private List<BusinessExecutor> businessExecutors;

    @Override
    public void execute() {
        if (!CollectionUtils.isEmpty(businessExecutors)) {
            for (BusinessExecutor businessExecutor : businessExecutors) {
                int businessType = businessExecutor.getBusinessType();
                TaskDto task = getOneTask(businessType);
                if (task != null) {
                    executeTask(businessExecutor, task);
                }
            }
        }
    }

    abstract protected TaskDto getOneTask(int type);

    private void executeTask(final BusinessExecutor businessExecutor, final TaskDto task) {
        try {
            businessExecutor.execute(task.getBusinessId());
            executeSuccess(task);
        } catch (Exception e) {
            logger.error("execute task error, {}", task.toString(), e);
            executeFail(task);
        }
    }

    abstract protected void executeSuccess(final TaskDto task);

    abstract protected void executeFail(final TaskDto task);

    public void setBusinessExecutors(List<BusinessExecutor> businessExecutors) {
        this.businessExecutors = businessExecutors;
    }

}
