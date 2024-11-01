package com.kyalo.example.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponseDto findStudentById(
            @PathVariable("id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{studentName}")
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("studentName") String name) {
        //return studentRepository.findAllByFirstNameContaining(name);
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }
}
