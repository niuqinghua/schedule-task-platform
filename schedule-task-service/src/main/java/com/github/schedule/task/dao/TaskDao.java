package com.github.schedule.task.dao;

import com.github.schedule.task.domain.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by niuqinghua on 15/10/28.
 */
public interface TaskDao {

    @Select("select id, business_id as businessId, type, status, retry_interval as retryInterval, retry_count as retryCount, "
            + "retry_limit as retryLimit, retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime "
            + "from task where status = 0 and type = #{type} order by id asc limit 1")
    Task getOne(int type);

    @Select("select id, business_id as businessId, type, status, retry_interval as retryInterval, retry_count as retryCount, "
            + "retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime "
            + "from task where id = #{id}")
    Task get(long id);

    @Insert("insert into task (business_id, type, status, retry_interval, retry_count, retry_limit, retry_time, content, created_time, updated_time) "
            + "values(#{businessId}, #{type}, #{status}, #{retryInterval}, #{retryCount}, #{retryLimit}, #{retryTime}, #{content}, NOW(), NOW())")
    long add(Task task);

    @Update("update task set status = #{status}, updated_time = NOW() where id = #{id}")
    int updateStatus(Task task);

    @Delete("delete from task where id = #{id}")
    int delete(Long id);

}
