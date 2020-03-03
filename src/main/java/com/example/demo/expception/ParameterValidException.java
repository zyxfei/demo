package com.example.demo.expception;

public class ParameterValidException extends Exception {
    public ParameterValidException(String msg) {
        super(msg);
    }
    public ParameterValidException(String msg, Exception e) {
        super(msg + " because of " + e.toString());
    }
}
