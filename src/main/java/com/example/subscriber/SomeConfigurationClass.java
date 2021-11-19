package com.example.subscriber;

import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeConfigurationClass {


    @Autowired
    private ManageTasksUseCase someBusinessDependency;

    @Bean
    public HandlerRegistry notificationEvents() {
        return HandlerRegistry.register()
                .handleCommand("test.command", someBusinessDependency::createTask, TestCommand.class)
                .serveQuery("test.query", c -> someBusinessDependency.findSomething(c), String.class)
                .listenEvent("test.event", someBusinessDependency::functionReturningMonoVoid, TestEvent.class);
    }


}
