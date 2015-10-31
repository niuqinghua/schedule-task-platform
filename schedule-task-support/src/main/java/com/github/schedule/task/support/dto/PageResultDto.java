package com.github.schedule.task.support.dto;

import java.io.Serializable;

/**
 * Created by niuqinghua on 15/10/31.
 */
public class PageResultDto<T> implements Serializable {

    private int count;

    private T result;

    public PageResultDto() {
    }

    public PageResultDto(int count, T result) {
        this.count = count;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
