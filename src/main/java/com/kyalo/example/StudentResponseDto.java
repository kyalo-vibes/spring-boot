package com.kyalo.example;

import java.time.LocalDateTime;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email
) {
}
