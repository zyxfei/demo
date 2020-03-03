package com.example.demo.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private Integer response = 0;

    @Override
    public String toString() {
        return response.toString() ;
    }

    public byte[] getBytes(String s) throws UnsupportedEncodingException {
        return this.toString().getBytes(s);
    }
}