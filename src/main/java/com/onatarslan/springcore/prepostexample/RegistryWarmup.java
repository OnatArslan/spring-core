package com.onatarslan.springcore.prepostexample;

import com.onatarslan.springcore.workspace.WorkspaceRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class RegistryWarmup {
    private final WorkspaceRegistry workspaceRegistry;

    public RegistryWarmup(WorkspaceRegistry workspaceRegistry) {
        this.workspaceRegistry = workspaceRegistry;
    }


    @PostConstruct
    void reportReady() {
        System.out.println("warmup: registry ready, workspace= " + workspaceRegistry.workspaceCount());
    }

    @PreDestroy
    void reportShutdown() {
        System.out.println("warmup: done");
    }
}
