package com.example.employee.exception;


public class ServerException extends RuntimeException{
    private String code;
    private String msg;

    public ServerException(String code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;

    }

}
