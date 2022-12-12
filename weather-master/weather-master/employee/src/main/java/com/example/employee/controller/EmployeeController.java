package com.example.employee.controller;

import com.example.employee.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @HystrixCommand(fallbackMethod = "fallBack",
            commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")}
    )
    public ResponseEntity<?> getAllEmp(@RequestParam int age) throws InterruptedException {
        log.info("执行了 getAllEmp。。。");
       Thread.sleep(4000);
        return new ResponseEntity<>(employeeService.fetchEmpAgeLargerThan(age), HttpStatus.OK);
    }

    public ResponseEntity<?> fallBack(@RequestParam int age){
        return new ResponseEntity<>("服务降级",HttpStatus.OK);
    }


}
