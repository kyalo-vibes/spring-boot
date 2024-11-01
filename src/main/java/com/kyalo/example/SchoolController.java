package com.kyalo.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(
            @RequestBody SchoolDto school
    ) {
        schoolRepository.save(toSchool(school));
        return school;
    }

    @GetMapping("/schools")
    public List<SchoolDto> createSchool() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }

    public School toSchool(SchoolDto school) {
        var schoolEntity = new School();
        schoolEntity.setName(school.name());
        return schoolEntity;
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
