package com.kyalo.example.student;

import jakarta.validation.constraints.NotNull;

public record StudentDto(
        @NotNull(message = "Kindly fill in the first name")
        String firstName,
        @NotNull(message = "Kindly fill in the last name")
        String lastName,
        @NotNull
        String email,
        Integer schoolId
) {
}
