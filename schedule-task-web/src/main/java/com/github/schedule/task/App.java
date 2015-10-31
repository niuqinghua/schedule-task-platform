package com.github.schedule.task;

import dream.prehnite.application.AbstractEmbeddedServerApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by niuqinghua on 15/10/30.
 */
@Configuration
@ComponentScan(value = {"com.github.schedule.task", "dream.prehnite"})
public class App extends AbstractEmbeddedServerApplication {

    public static void main(String[] args) {
        run(App.class, args);
    }

}
