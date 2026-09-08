package com.onatarslan.springcore.todo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
@Qualifier("uuid")
public class UUIDTodoIdGenerator implements TodoIdGenerator {

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }

}
