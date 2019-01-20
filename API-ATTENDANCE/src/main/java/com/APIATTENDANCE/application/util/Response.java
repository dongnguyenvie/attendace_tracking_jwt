package com.APIATTENDANCE.application.util;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Response<T> {

    private int code;
    @Nullable
    private T message;


    public Response(int code, @Nullable  T message) {
        this.code = code;
        this.message = message;
    
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }


    
}
