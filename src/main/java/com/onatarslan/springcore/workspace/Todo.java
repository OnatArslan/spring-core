package com.onatarslan.springcore.workspace;

public record Todo(
        String id,
        String workspaceId,
        String projectId,
        Status status
) {
    public enum Status{
        PENDING,IN_PROGRESS,DONE
    }
}
