package com.github.schedule.task.executor;

/**
 * Created by niuqinghua on 15/10/30.
 */
public interface BusinessExecutor {

    int getBusinessType();

    void execute(String businessId);

}
