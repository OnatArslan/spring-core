package com.onatarslan.springcore.todo;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepository {

    private final Map<UUID, Todo> todos = new ConcurrentHashMap<>();


    public void save(Todo todo) {
        todos.put(todo.id(), todo);
    }

}
