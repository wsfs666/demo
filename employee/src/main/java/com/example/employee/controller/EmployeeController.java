package com.example.employee.controller;

import com.example.employee.domain.Employee;
import com.example.employee.exception.ServerException;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;}

    @Autowired
    private RestTemplate restTemplate;




   /// list all employees
    @GetMapping
    public ResponseEntity findAll() throws JsonProcessingException {
        //Response res= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", Response.class);
        //String e= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", EmployeeDto.class);

//        String res= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode treeNode = objectMapper.readTree(res);
//        JsonNode data = treeNode.get("data");
//        List<Employee> employees = objectMapper.convertValue(data, new TypeReference<List<Employee>>() {
//        });

        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);




    }
//    public ResponseEntity<?> findAll()  {
//     //  return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
//
//    }


    //list employees whose age larger than 30
//    @GetMapping(params = "age")
//    //?age=
//    public ResponseEntity<EmployeeDto> GetAgeLargerThan(@RequestParam int age){
//        return new ResponseEntity<>(new EmployeeDto(employeeService.GetAgeLargerThan(age)),HttpStatus.OK);
//    }

    @GetMapping(params = "age")

    public ResponseEntity GetAgeLargerThan(@RequestParam Integer age) throws JsonProcessingException {
//        String res= restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode treeNode = objectMapper.readTree(res);
//        JsonNode data = treeNode.get("data");
//        List<Employee> employees = objectMapper.convertValue(data, new TypeReference<List<Employee>>() {
//        });
//
//        List<Employee> r=employees.stream().filter(e->e.getAge()>age).collect(Collectors.toList());

        return new ResponseEntity<>(employeeService.GetAgeLargerThan(age),HttpStatus.OK);




    }



//    TODO
//     *      1. create 2 endpoints
//     *          list all employees
//     *          list employees whose age larger than 30
//            *      2. @ControllerAdvice + @ExceptionHandler -> Exception.class -> internal server error
//     *      3. @ControllerAdvice + common response



}
