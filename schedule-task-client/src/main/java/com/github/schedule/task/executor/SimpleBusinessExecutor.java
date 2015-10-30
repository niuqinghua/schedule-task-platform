package com.github.schedule.task.executor;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class SimpleBusinessExecutor implements BusinessExecutor {

    private int businessType;

    @Override
    public int getBusinessType() {
        return businessType;
    }

    @Override
    public void execute(String businessId) {
        System.out.println(businessId);
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }
}
