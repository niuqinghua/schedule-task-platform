package com.github.schedule.task.dao;

import com.github.schedule.task.domain.Task;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by niuqinghua on 15/10/28.
 */
public interface HistoryTaskDao {

    @Insert("insert into history_task "
            + "values(#{id}, #{businessId}, #{type}, #{status}, #{retryInterval}, #{retryCount}, #{retryTime}, #{content}, #{createdTime}, #{updatedTime})")
    void add(Task task);

}
