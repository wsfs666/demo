package com.example.university.domain.dto;
import com.example.university.domain.entity.Student;

public class StudentDto {
    private String id;
    private String name;

    StudentDto(){};
    StudentDto(String id, String name){
        this.id=id;
        this.name=name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
