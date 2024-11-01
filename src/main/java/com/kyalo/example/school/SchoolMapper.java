package com.kyalo.example.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto school) {
        var schoolEntity = new School();
        schoolEntity.setName(school.name());
        return schoolEntity;
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
