package com.onatarslan.springcore.workspace;

import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {

    private final WorkspaceRegistry registry;

    public WorkspaceService(WorkspaceRegistry registry) {
        this.registry = registry;
    }


}
