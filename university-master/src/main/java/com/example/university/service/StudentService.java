package com.example.university.service;

import com.example.university.domain.CommonResponse;
import com.example.university.domain.dto.StudentDto;
import com.example.university.domain.dto.TeacherDto;
import com.example.university.domain.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    CommonResponse findById(String id);
    CommonResponse findAll();
    CommonResponse insert(Student stu);

    void updateById(StudentDto dto);

    List<TeacherDto> findAllTeachers(String id);
}
