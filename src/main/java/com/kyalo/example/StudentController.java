package com.kyalo.example;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //Create student using entity
//    @PostMapping("/students")
//    public Student createStudent(
//            @RequestBody Student student) {
//        student.setCreatedAt(LocalDateTime.now());
//        return studentRepository.save(student);
//    }

    //Create student using DTO
    @PostMapping("/students")
    public StudentResponseDto createStudent(
            @RequestBody StudentDto student) {
        var newStudent = toStudent(student);
        studentRepository.save(newStudent);
        return toStudentResponseDto(newStudent);
    }

    private Student toStudent(StudentDto studentDto) {
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

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(
            @PathVariable("id") Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{studentName}")
    public List<Student> findStudentByName(
            @PathVariable("studentName") String name) {
        //return studentRepository.findAllByFirstNameContaining(name);
        return studentRepository.findAllByFirstNameLike("%" + name + "%");
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }
}
