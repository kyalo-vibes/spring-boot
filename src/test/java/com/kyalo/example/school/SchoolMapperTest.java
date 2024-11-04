package com.kyalo.example.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolMapperTest {
    private SchoolMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new SchoolMapper();
    }

    @Test
    void shouldMapSchoolDtoToSchool() {
        //Given
        SchoolDto dto = new SchoolDto("Parklands School");
        //Then
        School school = mapper.toSchool(dto);
        //When
        assertEquals(dto.name(), school.getName());
    }

    @Test
    void shouldMapSchoolToSchoolDto() {
        //Given
        School school = new School("Parklands School");
        //Then
        SchoolDto dto = mapper.toSchoolDto(school);
        //When
        assertEquals(school.getName(), dto.name());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenSchoolIsNull() {
        //Given
        var exp = assertThrows(NullPointerException.class, () -> mapper.toSchoolDto(null));
        //Then
        assertEquals("The school cannot be null", exp.getMessage());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenSchoolDtoIsNull() {
        //Given
        var exp = assertThrows(NullPointerException.class, () -> mapper.toSchool(null));
        //Then
        assertEquals("The school dto cannot be null", exp.getMessage());
    }
}