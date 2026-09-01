package com.onatarslan.springcore.workspace;

import com.onatarslan.springcore.idgen.TaskIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {

    private final WorkspaceRegistry registry;
    private final TaskIdGenerator idGenerator;

    public WorkspaceService(WorkspaceRegistry registry,
                            @Qualifier("uuid") TaskIdGenerator generator) {
        this.registry = registry;
        this.idGenerator = generator;
    }


}
