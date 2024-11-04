package com.kyalo.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto school) {
        var schoolEntity = schoolMapper.toSchool(school);
        schoolRepository.save(schoolEntity);
        return schoolMapper.toSchoolDto(schoolEntity);
    }

    public List<SchoolDto> findAllSchools() {
        return schoolRepository.findAll()
                .stream().
                map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public void deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
    }
}
