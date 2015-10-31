package com.github.schedule.task.dao;

import com.github.schedule.task.domain.PageParameter;
import com.github.schedule.task.domain.TaskRetryRule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by niuqinghua on 15/10/31.
 */
public interface TaskRetryRuleDao {

    @Insert("insert into task_retry_rule (task_type, retry_interval, retry_limit, status, created_time, updated_time) "
            + "values(#{taskType}, #{retryInterval}, #{retryLimit}, #{status}, NOW(), NOW())")
    void add(TaskRetryRule taskRetryRule);

    @Update("update task_retry_rule set task_type = #{taskType}, retry_interval = #{retryInterval}, "
            + "retry_limit = #{retryLimit}, status = #{status}, update_time = NOW() where id = #{id}")
    void update(TaskRetryRule taskRetryRule);

    @Delete("delete from task_retry_rule where id = #{id}")
    void delete(long id);

    @Select("select id, task_type as taskType, retry_interval as retryInterval, retry_limit as retryLimit, status, created_time as createdTime, updated_time as updatedTime "
            + "from task_retry_rule where id = #{id}")
    TaskRetryRule get(long id);

    @Select("select id, task_type as taskType, retry_interval as retryInterval, retry_limit as retryLimit, status, created_time as createdTime, updated_time as updatedTime "
            + "from task_retry_rule where task_type = #{taskType}")
    TaskRetryRule getByTaskType(int taskType);

    List<TaskRetryRule> find(PageParameter pageParameter);

    @Select("select count(1) from task_retry_rule")
    int count();

}
