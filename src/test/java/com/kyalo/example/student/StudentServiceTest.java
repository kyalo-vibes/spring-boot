package com.kyalo.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        //given
        StudentDto studentDto = new StudentDto("Kevin", "Kyalo", "kevin@gmail.com", 2);
        Student student = new Student("Kevin", "Kyalo", "kevin@gmail.com", 24);
        Student savedStudent = new Student("Kevin", "Kyalo", "kevin@gmail.com", 24);
        savedStudent.setId(1);

        //Mock the calls
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDto("Kevin", "Kyalo", "kevin@gmail.com"));
        //when
        StudentResponseDto responseDto = studentService.createStudent(studentDto);
        //then
        assertNotNull(responseDto);
        assertEquals(student.getFirstName(), responseDto.firstName());
        assertEquals(student.getLastName(), responseDto.lastName());
        assertEquals(student.getEmail(), responseDto.email());

        verify(studentMapper, times(1)).toStudent(studentDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_list_of_students() {
        //given
        Student student1 = new Student("Kevin", "Kyalo", "kevin@gmail.com", 24);
        Student student2 = new Student("Daniel", "Mulwa", "daniel@gmail.com", 15);
        Student student3 = new Student("Vincent", "Muema", "kevin@gmail.com", 29);
        StudentResponseDto studentResponseDto1 = new StudentResponseDto("Kevin", "Kyalo", "kevin@gmail.com");
        StudentResponseDto studentResponseDto2 = new StudentResponseDto("Daniel", "Mulwa", "daniel@gmail.com");
        StudentResponseDto studentResponseDto3 = new StudentResponseDto("Vincent", "Muema", "kevin@gmail.com");
        List<Student> students = Arrays.asList(student1, student2, student3);
        List<StudentResponseDto> dtos = Arrays.asList(studentResponseDto1, studentResponseDto2, studentResponseDto3);
        //Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(student1)).thenReturn(studentResponseDto1);
        when(studentMapper.toStudentResponseDto(student2)).thenReturn(studentResponseDto2);
        when(studentMapper.toStudentResponseDto(student3)).thenReturn(studentResponseDto3);
        //when
        List<StudentResponseDto> responseDtos = studentService.findAllStudents();
        //then
        assertEquals(3, responseDtos.size());

        StudentResponseDto dto = responseDtos.get(0);
        assertEquals("Kevin", dto.firstName());
        assertEquals("Kyalo", dto.lastName());
        assertEquals("kevin@gmail.com", dto.email());

        dto = responseDtos.get(1);
        assertEquals("Daniel", dto.firstName());
        assertEquals("Mulwa", dto.lastName());
        assertEquals("daniel@gmail.com", dto.email());

        dto = responseDtos.get(2);
        assertEquals("Vincent", dto.firstName());
        assertEquals("Muema", dto.lastName());
        assertEquals("kevin@gmail.com", dto.email());

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id() {
        //given
        Student student = new Student("Kevin", "Kyalo", "kevin@gmail.com", 24);
        student.setId(1);
        StudentResponseDto studentResponseDto = new StudentResponseDto("Kevin", "Kyalo", "kevin@gmail.com");
        //Mock the calls
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(studentResponseDto);
        //when
        StudentResponseDto responseDto = studentService.findStudentById(1);
        //then
        assertEquals(student.getFirstName(), responseDto.firstName());
        assertEquals(student.getLastName(), responseDto.lastName());
        assertEquals(student.getEmail(), responseDto.email());

        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    public void should_return_student_by_name() {
        //given
        String name = "Kevin";
        Student student1 = new Student("Kevin", "Kyalo", "kevin@gmail.com", 24);
        Student student2 = new Student("Kevin", "Mulwa", "daniel@gmail.com", 15);
        List<Student> students = Arrays.asList(student1, student2);
        StudentResponseDto studentResponseDto1 = new StudentResponseDto("Kevin", "Kyalo", "kevin@gmail.com");
        StudentResponseDto studentResponseDto2 = new StudentResponseDto("Kevin", "Mulwa", "daniel@gmail.com");
        //Mock the calls
        when(studentRepository.findAllByFirstNameContaining(name)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(student1)).thenReturn(studentResponseDto1);
        when(studentMapper.toStudentResponseDto(student2)).thenReturn(studentResponseDto2);
        //when
        List<StudentResponseDto> responseDto = studentService.findStudentByName(name);
        //then
        assertEquals(students.size(), responseDto.size());
        assertEquals("Kevin", responseDto.get(0).firstName());
        assertEquals("Kyalo", responseDto.get(0).lastName());
        assertEquals("kevin@gmail.com", responseDto.get(0).email());
        assertEquals("Kevin", responseDto.get(1).firstName());
        assertEquals("Mulwa", responseDto.get(1).lastName());
        assertEquals("daniel@gmail.com", responseDto.get(1).email());

        verify(studentRepository, times(1)).findAllByFirstNameContaining("Kevin");
    }

    @Test
    public void should_delete_student_by_id() {
        //given
        int id = 1;
        //Mock the calls
        doNothing().when(studentRepository).deleteById(id);
        //when
        studentService.deleteStudent(id);
        //then
        verify(studentRepository, times(1)).deleteById(id);
    }
}