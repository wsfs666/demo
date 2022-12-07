package com.example.employee.service;

import com.example.employee.domain.Employee;
import com.example.employee.domain.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.*;
@Service
public interface EmployeeService {

    List<Employee> findAll() throws JsonProcessingException;

    List<Employee> GetAgeLargerThan(int id) throws JsonProcessingException;
}
