package com.onatarslan.springcore.todo;

import com.onatarslan.springcore.project.Project;
import com.onatarslan.springcore.project.ProjectRepository;
import com.onatarslan.springcore.project.ProjectService;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.UUID;


public class TodoServiceTest {

    @Test
    void createTodoForExistingProject() {
        ProjectRepository projectRepository = new ProjectRepository();
        ProjectService projectService = new ProjectService(projectRepository);
        TodoRepository todoRepository = new TodoRepository();
        TodoIdGenerator todoIdGenerator = new UUIDTodoIdGenerator();

        TodoService todoService = new TodoService(todoRepository, projectService, List.of(todoIdGenerator), Clock.systemUTC());

        Project project = projectService.create("Orbit");

        Todo todo = todoService.create(project.id(), "Orbit todo");

    }

}
