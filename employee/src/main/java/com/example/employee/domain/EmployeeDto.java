package com.example.employee.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

//    private int id;
//
//    private String name;
//
//    private int age;
//
//    private int salary;

    private List<Employee> list;




    public List<Employee> getList() {
        return list;
    }




}
