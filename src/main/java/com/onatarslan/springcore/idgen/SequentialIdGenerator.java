package com.onatarslan.springcore.idgen;

import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
@Primary // Burada TaskIdGenerator implement eden 2 Componentta belirsizlik varsa bunu sec demektir
public class SequentialIdGenerator implements TaskIdGenerator {

    private final AtomicLong counter = new AtomicLong();

    @Override
    public String nextId() {
        return "task-" + counter.incrementAndGet();
    }


}
