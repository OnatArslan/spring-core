package com.onatarslan.springcore.workspace;

import com.onatarslan.springcore.idgen.TaskIdGenerator;
import com.onatarslan.springcore.project.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {

    private final WorkspaceRegistry registry;
    private final TaskIdGenerator idGenerator;
    private final int maxProjectPerWorkspace;
    private final ProjectProperties properties;

    public WorkspaceService(WorkspaceRegistry registry,
                            @Qualifier("uuid") TaskIdGenerator generator,
                            @Value("${orbit.workspace.max-projects-per-workspace:30}") int maxProjectPerWorkspace,
                            ProjectProperties properties

    ) {
        System.out.println(maxProjectPerWorkspace);
        System.out.println(properties);
        this.registry = registry;
        this.idGenerator = generator;
        this.maxProjectPerWorkspace = maxProjectPerWorkspace;
        this.properties = properties;
    }


}
