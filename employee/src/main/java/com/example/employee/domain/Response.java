package com.example.employee.domain;

import lombok.Data;

@Data
public class Response {

    private String status;
    private Object data;
    private String message;

}
