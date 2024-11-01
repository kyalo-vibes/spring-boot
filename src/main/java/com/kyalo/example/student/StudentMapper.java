package com.kyalo.example.student;

import com.kyalo.example.school.School;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school = new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);

        student.setCreatedAt(LocalDateTime.now());
        return  student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }
}
