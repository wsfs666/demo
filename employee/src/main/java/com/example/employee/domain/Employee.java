package com.example.employee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("id")
    private int id;
   @JsonProperty("employee_name")
    private String name;
    @JsonProperty("employee_age")
    private int age;
    @JsonProperty("employee_salary")
    private int salary;

    @JsonProperty("profile_image")
    private String image;

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override

    public String toString(){
        return this.id+","+this.name;
    }
}
