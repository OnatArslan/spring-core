package com.onatarslan.springcore.todo;

import java.time.Instant;
import java.util.UUID;

public record Todo(
        UUID id,
        UUID projectId,
        String title,
        TodoStatus status,
        Instant createdAt
) {



}
