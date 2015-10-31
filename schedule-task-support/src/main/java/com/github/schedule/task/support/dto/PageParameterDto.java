package com.github.schedule.task.support.dto;

import java.io.Serializable;

/**
 * Created by niuqinghua on 15/10/31.
 */
public class PageParameterDto implements Serializable {

    private int pageNo;

    private int pageSize;

    public PageParameterDto() {

    }

    public PageParameterDto(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
