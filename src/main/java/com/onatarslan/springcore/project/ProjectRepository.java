package com.onatarslan.springcore.project;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProjectRepository {
    private final Map<UUID, Project> projects = new ConcurrentHashMap<>();


    public ProjectRepository() {
    }

    public Project save(Project project) {
        projects.put(project.id(), project);
        return project;
    }

    public boolean existsById(UUID id) {
        return projects.containsKey(id);
    }

}
