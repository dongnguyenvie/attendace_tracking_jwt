package com.APIATTENDANCE.application.util;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ResUtil {


    public static Map<String, Object> getUnknownErrorMap() {
        return getMap(Code.UNKNOWN_ERROR, Message.UNKNOWN_ERROR);
    }

    public static Map<String, Object> getParamErrorMap() {
        return getMap(Code.PARAM_ERROR, Message.PARAM_ERROR);
    }

    public static Map<String, Object> getFailedMap() {
        return getMap(Code.FAILED, Message.FAILED);
    }

    public static Map<String, Object> getSuccessMap() {
        return getSuccessMap(null);
    }
  
    public static Map<String, Object> getMap(Exception e) {
        return getMap(Code.FAILED, e.getMessage());
    }

    public static Map<String, Object> getMap(Throwable e) {
        return getMap(Code.FAILED, e.getMessage());
    }

    public static <T> Map<String, Object> getSuccessMap(@Nullable T data) {
        return getMap(Code.SUCCESS, Message.SUCCESS);
    }

    
    public static <T> Map<String, Object> getMap(int code, @Nullable T message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", message);
        return map;
    }

    public static Response<String> getUnknownErrorRes() {
        return new Response<>(Code.UNKNOWN_ERROR, Message.UNKNOWN_ERROR);
    }

    public static Response<String> getParamErrorRes() {
        return new Response<>(Code.PARAM_ERROR, Message.PARAM_ERROR);
    }

    public static Response<String> getFailedRes() {
        return new Response<>(Code.FAILED, Message.FAILED);
    }

    public static Response<String> getSuccessRes() {
        return new Response<>(Code.SUCCESS, Message.SUCCESS);
    }
    
    public static Response<String> get(Exception e) {
        return new Response<>(Code.FAILED, e.getMessage());
    }

    public static Response<String> get(Throwable e) {
        return new Response<>(Code.FAILED, e.getMessage());
    }

    public static <T> Response<T> getSuccessResponse(@Nullable T data) {
        return new Response<>(Code.SUCCESS, data);
    }
    
    public static <T> Response<T> get(int code,@Nullable T message) {
        return new Response<>(code, message);
    }


}
