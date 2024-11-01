package com.kyalo.example.student;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
