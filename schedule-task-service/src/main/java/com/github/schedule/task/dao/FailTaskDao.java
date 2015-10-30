package com.github.schedule.task.dao;

import com.github.schedule.task.domain.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by niuqinghua on 15/10/28.
 */
public interface FailTaskDao {

    @Select("select id, business_id as businessId, type, status, retry_interval as retryInterval, retry_count as retryCount, "
            + "retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime"
            + " from fail_task order where status = 0 by retry_time asc limit 1")
    Task getOne();

    @Select("select id, business_id as businessId, type, status, retry_interval as retryInterval, retry_count as retryCount, "
            + "retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime"
            + " from fail_task order where business_id = #{businessId}")
    Task getByBusinessId(String businessId);

    @Insert("insert into fail_task "
            + "values(#{id}, #{businessId}, #{type}, #{status}, #{retryInterval}, #{retryCount}, #{retryTime}, #{content}, #{createdTime}, NOW())")
    long add(Task task);

    @Update("update fail_task set status = #{status}, retry_count = #{retryCount}, retry_time = #{retryTime}, updated_time = NOW()"
            + " where id = #{id}")
    int update(Task task);

    @Delete("delete from fail_task where id = #{id}")
    int delete(Long id);

}
