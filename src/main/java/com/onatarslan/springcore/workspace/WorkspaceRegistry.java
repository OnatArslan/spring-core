package com.onatarslan.springcore.workspace;


import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component()
public class WorkspaceRegistry {

    private final Map<String, Workspace> workspaces = new ConcurrentHashMap<>();
    private final Map<String, Project> projects = new ConcurrentHashMap<>();
    private final Map<String, Todo> todos = new ConcurrentHashMap<>();


    public void save(Workspace workspace){
        workspaces.put(workspace.id(), workspace);
    }

    public void save(Project project) {
        projects.put(project.id(), project);
    }

    public void save(Todo todo) {
        todos.put(todo.id(), todo);
    }

    public Optional<Workspace> findWorkspaceById(String id) {
        return Optional.ofNullable(workspaces.get(id));
    }

    public Optional<Project> findProject(String id) {
        return Optional.ofNullable(projects.get(id));
    }

    public List<Todo> findTodosByWorkspace(String workspaceId) {
        return todos.values().stream().filter(todo -> Objects.equals(todo.workspaceId(), workspaceId)).toList();
    }

    public List<Todo> findTodosByProject(String projectId) {
        return todos.values().stream().filter(todo -> Objects.equals(todo.projectId(), projectId)).toList();
    }

    public int workspaceCount() {
        return workspaces.size();
    }


}
