package com.example.university.respository.impl;

import com.example.university.domain.entity.Student;
import com.example.university.respository.StudentCustomRepo;
//import jakarta.persistence.EntityManager;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class StudentCustomRepoImpl implements StudentCustomRepo {

    private final EntityManager entityManager;

    @Autowired
    public StudentCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student insert(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public void updateById(Student student) {
        entityManager.merge(student);
    }
}
