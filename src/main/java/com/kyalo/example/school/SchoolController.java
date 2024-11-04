package com.kyalo.example.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(
            @RequestBody SchoolDto school
    ) {
        return schoolService.createSchool(school);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAllSchools() {
        return schoolService.findAllSchools();
    }

    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable("id") Integer id) {
        schoolService.deleteSchool(id);
    }
}
