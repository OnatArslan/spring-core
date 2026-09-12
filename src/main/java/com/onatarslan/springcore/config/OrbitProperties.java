package com.onatarslan.springcore.config;

import com.onatarslan.springcore.todo.Todo;
import com.onatarslan.springcore.todo.TodoStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties(prefix = "orbit")
@Validated
public record OrbitProperties(
        @NotNull
        @Valid
        Project project,

        @NotNull
        @Valid
        Todo todo
) {

    public record Project(
            @Positive int defaultLimit
    ) {

    }

    public record Todo(
            @NotNull
            TodoStatus defaultStatus,
            @Positive
            @DefaultValue("100")
            int maxPerProject,
            @NotNull
            IdStrategy idStrategy,
            boolean cleanupEnabled,
            @NotNull
            @DefaultValue("30m")
            Duration cleanupInterval
    ) {

    }

    public enum IdStrategy {
        UUID, SEQUENTIAL
    }


}
