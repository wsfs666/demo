package com.example.university.service.impl;


import com.example.university.domain.CommonResponse;
import com.example.university.domain.dto.StudentDto;
import com.example.university.domain.dto.TeacherDto;
import com.example.university.domain.entity.Student;
import com.example.university.domain.entity.Teacher;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.respository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CommonResponse findById(String id) {
        Optional<Student> stu =  studentRepository.findById(id);
//        if(stu.isEmpty()) {
        if(!stu.isPresent()) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new CommonResponse(0, new Date(), stu.get());
    }

    @Override
    public CommonResponse findAll() {
        List<Student> stuList =  studentRepository.findAll();
        return new CommonResponse(0, new Date(), stuList);
    }

    @Override
    @Transactional
    public CommonResponse insert(Student stu) {
        Student student = studentRepository.insert(stu);
        return new CommonResponse(0, new Date(), student.getId());
    }


    @Override
    public void updateById(StudentDto dto) {
        if(dto == null || dto.getId() == null){
            throw new ResourceNotFoundException("param can not be null");
        }
        Student student = new Student(dto.getId(),dto.getName());
        studentRepository.updateById(student);
    }

    @Override
    public List<TeacherDto> findAllTeachers(String id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(!optional.isPresent()){
            throw new ResourceNotFoundException("can not found teacher");
        }
        Student student = optional.get();
        Set<Teacher> teacherSet = student.getTeachers();
        return teacherSet.stream().map(teacher -> new TeacherDto(teacher.getId(),teacher.getName())).collect(Collectors.toList());
    }
}
