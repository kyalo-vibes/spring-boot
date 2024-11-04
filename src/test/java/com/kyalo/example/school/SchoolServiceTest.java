package com.kyalo.example.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SchoolServiceTest {
    @InjectMocks
    private SchoolService schoolService;
    @Mock
    private SchoolRepository schoolRepository;
    @Mock
    private SchoolMapper schoolMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_create_school() {
        //Given
        SchoolDto schoolDto = new SchoolDto("Parklands School");
        School school = new School("Parklands School");
        //Mock the calls
        when(schoolMapper.toSchool(schoolDto)).thenReturn(school);
        when(schoolRepository.save(school)).thenReturn(school);
        when(schoolMapper.toSchoolDto(school)).thenReturn(schoolDto);
        //When
        schoolService.createSchool(schoolDto);
        //Then
        verify(schoolRepository, times(1)).save(any(School.class));
    }

    @Test
    public void should_return_list_of_schools() {
        //Given
        School school1 = new School("Parklands School");
        School school2 = new School("Crownlands School");
        List<School> schools = Arrays.asList(school1, school2);
        //Mock the calls
        when(schoolRepository.findAll()).thenReturn(schools);
        when(schoolMapper.toSchoolDto(school1)).thenReturn(new SchoolDto("Parklands School"));
        when(schoolMapper.toSchoolDto(school2)).thenReturn(new SchoolDto("Crownlands School"));
        //When
        var result = schoolService.findAllSchools();
        //Then
        assertEquals(2, result.size());
        assertEquals(school1.getName(), result.get(0).name());
        assertEquals(school2.getName(), result.get(1).name());
        verify(schoolRepository, times(1)).findAll();
    }

    @Test
    public void should_delete_school() {
        //Given
        Integer id = 1;
        //Mock the calls
        when(schoolRepository.existsById(id)).thenReturn(true);
        //When
        schoolService.deleteSchool(id);
        //Then
        verify(schoolRepository, times(1)).deleteById(id);
    }
}