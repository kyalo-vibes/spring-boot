package com.kyalo.example.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto school) {
        if(school == null){
            throw new NullPointerException("The school dto cannot be null");
        }
        var schoolEntity = new School();
        schoolEntity.setName(school.name());
        return schoolEntity;
    }

    public SchoolDto toSchoolDto(School school) {
        if (school == null) {
            throw new NullPointerException("The school cannot be null");
        }
        return new SchoolDto(school.getName());
    }
}
