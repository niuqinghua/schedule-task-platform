package com.github.schedule.task.dto;

import java.io.Serializable;

/**
 * Created by niuqinghua on 15/10/30.
 */
public class TaskDto implements Serializable {

    private long id;

    private String businessId;

    private int type;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
