package com.github.schedule.task.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by niuqinghua on 15/10/28.
 */
@Configuration
@ImportResource(value = {"classpath:spring/spring-schedule.xml", "classpath:spring/spring-dubbo.xml"})
public class ScheduleConfiguration {

}
