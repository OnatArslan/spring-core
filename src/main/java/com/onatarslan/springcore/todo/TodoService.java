package com.onatarslan.springcore.todo;

import com.onatarslan.springcore.project.ProjectService;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final ProjectService projectService;
    private final List<TodoIdGenerator> idGenerators;
    private final Clock clock;

    @Autowired

    public TodoService(TodoRepository todoRepository, ProjectService projectService, List<TodoIdGenerator> idGenerators, Clock clock) {
        this.todoRepository = todoRepository;
        this.projectService = projectService;
        this.idGenerators = List.copyOf(idGenerators);
        this.clock = clock;
    }


    public Todo create(UUID projectId, String title) {
        Objects.requireNonNull(projectId, "projectId must not be null");
        Objects.requireNonNull(title, "title must not be null");

        if (title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }

        if (!projectService.exists(projectId)) {
            throw new IllegalArgumentException(
                    "project does not exist: " + projectId
            );
        }

        Todo todo = new Todo(
                UUID.randomUUID(),
                projectId,
                title,
                Todo.TodoStatus.PENDING,
                clock.instant()
        );

        return todo;
    }


}
