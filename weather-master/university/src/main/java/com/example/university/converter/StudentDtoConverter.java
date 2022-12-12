package com.example.university.converter;

import com.example.university.domain.entity.Student;
import com.example.university.domain.dto.StudentDto;
import org.springframework.stereotype.Component;
import org.modelmapper.*;

@Component
public class StudentDtoConverter {
    public StudentDto convertEntityToDto(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        StudentDto dto = modelMapper.map(student, StudentDto.class);
        return dto;
    }

    public Student convertDtoToEntity(StudentDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(dto, Student.class);
        return student;
    }

}
