package com.example.employee.service.impl;


import com.example.employee.domain.Employee;
import com.example.employee.domain.EmployeeDto;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @Autowired
    public EmployeeImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> findAll() throws JsonProcessingException {
        String res= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode treeNode = objectMapper.readTree(res);
        JsonNode data = treeNode.get("data");
        List<Employee> employees = objectMapper.convertValue(data, new TypeReference<List<Employee>>() {
        });

        return employees;




    }

    @Override
    public List<Employee> GetAgeLargerThan(int age) throws JsonProcessingException {
       // String url="https://dummy.restapiexample.com/api/v1/employees";

            String res= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode treeNode = objectMapper.readTree(res);
            JsonNode data = treeNode.get("data");
            List<Employee> employees = objectMapper.convertValue(data, new TypeReference<List<Employee>>() {
            });

            List<Employee> r=employees.stream().filter(e->e.getAge()>age).collect(Collectors.toList());
            return r;
    }
}
