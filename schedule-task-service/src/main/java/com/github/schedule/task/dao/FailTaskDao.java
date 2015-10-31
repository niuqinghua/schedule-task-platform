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
            + "retry_limit as retryLimit, retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime "
            + "from fail_task where status = 0 and type = #{type} order by retry_time asc limit 1")
    Task getOne(int type);

    @Select("select id, business_id as businessId, type, status, retry_interval as retryInterval, retry_count as retryCount, "
            + "retry_limit as retryLimit, retry_time as retryTime, content, created_time as createdTime, updated_time as updatedTime "
            + "from fail_task where id = #{id}")
    Task get(long id);

    @Insert("insert into fail_task "
            + "values(#{id}, #{businessId}, #{type}, #{status}, #{retryInterval}, #{retryCount}, #{retryLimit}, #{retryTime}, #{content}, #{createdTime}, NOW())")
    long add(Task task);

    @Update("update fail_task set status = #{status}, retry_count = #{retryCount}, retry_time = #{retryTime}, updated_time = NOW()"
            + " where id = #{id}")
    int update(Task task);

    @Delete("delete from fail_task where id = #{id}")
    int delete(Long id);

}
