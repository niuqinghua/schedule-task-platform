package com.github.schedule.task.domain;

/**
 * Created by niuqinghua on 15/10/31.
 */
public class PageResult<T> {

    private int count;

    private T result;

    public PageResult() {
    }

    public PageResult(int count, T result) {
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
