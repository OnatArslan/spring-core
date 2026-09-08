package com.onatarslan.springcore.project;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(String name) {
        Objects.requireNonNull(name, "name must not be null");

        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }

        return projectRepository.save(
                new Project(UUID.randomUUID(), name)
        );
    }

    public boolean exists(UUID projectId) {
        return projectRepository.existsById(projectId);
    }

}
