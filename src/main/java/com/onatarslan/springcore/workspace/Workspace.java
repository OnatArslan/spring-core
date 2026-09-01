package com.onatarslan.springcore.workspace;

public record Workspace(
        String id,
        String name,
        String slug,
        Plan plan
) {

    public enum Plan {
        FREE,TEAM
    }

}
