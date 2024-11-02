package com.kyalo.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("Kevin", "Kyalo", "kevin@gmail.com", 2);
        Student student = mapper.toStudent(dto);
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudenttoStudentResponseDto() {
        //Given
        Student student = new Student("Kevin", "Kyalo", "kevin@gmail.com", 2);

        //When
        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getLastName(), dto.lastName());
        assertEquals(student.getEmail(), dto.email());
    }

    @Test
    public void should_throw_null_point_exception_error_when_studentdto_is_null(){
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));

        assertEquals("The student dto cannot be null", exp.getMessage());
    }
}