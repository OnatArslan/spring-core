package com.onatarslan.springcore.todo;

import com.onatarslan.springcore.config.OrbitProperties;
import com.onatarslan.springcore.project.ProjectService;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TodoService {


    private final TodoRepository todoRepository;
    private final ProjectService projectService;
    //    private final List<TodoIdGenerator> idGenerators;
    private final TodoIdGenerator todoIdGenerator;
    private final Clock clock;
    private final int maxTodosPerProject;
    private final OrbitProperties.Todo todoProperties;
    private static final Logger log = LoggerFactory.getLogger(TodoService.class);


    @Autowired

    public TodoService(TodoRepository todoRepository, ProjectService projectService,@Qualifier("uuid") TodoIdGenerator todoIdGenerator , Clock clock, @Value("${orbit.todo.max-per-project:100}") int maxTodosPerProject, OrbitProperties todoProperties) {
        this.todoRepository = todoRepository;
        this.projectService = projectService;
        this.todoIdGenerator = todoIdGenerator;
        this.clock = clock;
        this.maxTodosPerProject = maxTodosPerProject;
        this.todoProperties = todoProperties.todo();
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
                TodoStatus.PENDING,
                clock.instant()
        );

        if(log.isDebugEnabled()){ // If we use expensive operation in here (this is not a good example) we can use isDebugEnabled
        log.debug("Todo created: todoId={}, projectId={}, status={}", todo.id(), todo.projectId(), todo.status());
        }


        return todo;
    }


}
