package com.example.university.domain.dto;



public class StudentDto {


    private String id;
    private String name;

    public StudentDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
