package com.onatarslan.springcore.project;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record ExampleForValidation(
        @NotNull
        @Valid
        InnerExampleForValidation innerExample,

        @NotBlank
        String name,

        @Positive
        int number
        ) {


    public record InnerExampleForValidation(
            @NotBlank String name,
            @Positive int number
    ) {

    }


}
