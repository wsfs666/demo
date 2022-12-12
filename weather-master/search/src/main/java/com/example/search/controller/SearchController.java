package com.example.search.controller;

import com.example.common.domain.GeneralResponse;
import com.example.search.feign.UniversityClient;
import com.example.search.service.EmployeeService;
import com.example.search.service.UniversityService;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class SearchController {

    private final EmployeeService employeeService;
    private final UniversityService universityService;

    @Autowired
    private UniversityClient universityClient;

    public SearchController(EmployeeService employeeService, UniversityService universityService) {
        this.employeeService = employeeService;
        this.universityService = universityService;
    }

    @GetMapping("/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages, HttpServletRequest request) {
        log.info("param:{},requestId:{}",ages,request.getHeader("REQUEST_ID"));
        //TODO
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }

    //fetch data from university service
    //fetch all employees
    //fetch all student info

    @GetMapping("/search/universities")
    public ResponseEntity<?> getUniversity(){
        return new ResponseEntity<>(universityService.fetchAllTeacherInfoBySid(),HttpStatus.OK);

    }

    @GetMapping("/search/allStudents")
    public Object getStudents(HttpServletRequest request){
        log.info("requestId:{}",request.getHeader("REQUEST_ID"));
        return universityClient.findAllStus().getData();
    }

}
