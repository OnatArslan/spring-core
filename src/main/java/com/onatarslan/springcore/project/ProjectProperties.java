package com.onatarslan.springcore.project;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "example.project")
@Validated
public record ProjectProperties(
        @DefaultValue("pr") @NotBlank @Length(min = 1, max = 250) String titlePrefix,
        @DefaultValue("250") @Min(1) @Max(300) int titleMaxLength,
        @Valid @NotNull Todo todo
) {

    public record Todo(
            @DefaultValue("td") @NotBlank String titlePrefix,
            @DefaultValue("250") int titleMaxLength
    ) {

    }




}
