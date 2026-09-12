package com.onatarslan.springcore.todo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class TodoConfiguration {

    @Bean
    @ConditionalOnProperty(
            prefix = "orbit.todo",
            name = "id-strategy",
            havingValue = "uuid",
            matchIfMissing = true // matchIfMissing means if orbit.todo.id-strategy is empty then choose this one
    )
    public TodoIdGenerator uuidTodoIdGenerator() {
        return new UUIDTodoIdGenerator();
    }


    @Bean
    @ConditionalOnProperty(prefix = "orbit.todo", name = "id-strategy", havingValue = "sequential")
    public TodoIdGenerator sequentialTodoIdGenerator() {
        return new SequentialTodoIdGenerator();
    }
}
