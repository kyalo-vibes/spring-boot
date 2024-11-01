package com.kyalo.example;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
