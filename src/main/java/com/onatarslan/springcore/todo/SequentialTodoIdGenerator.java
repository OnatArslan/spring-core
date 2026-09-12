package com.onatarslan.springcore.todo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Qualifier("sequential") // we can use this name in injection point
public class SequentialTodoIdGenerator implements TodoIdGenerator {

    private final AtomicLong sequence = new AtomicLong();

    @Override
    public UUID nextId() {
        return new UUID(0L, sequence.incrementAndGet());
    }

}
