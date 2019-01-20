package com.APIATTENDANCE.application.entity.format;


import java.util.HashMap;
import java.util.Map;

public class JsonFormat {

	private String[] key;
	private Object[] value;
	private Map<String, Object> map;
	private static Map<String, Object> status;
	
	public JsonFormat() {}
	public JsonFormat(String[] key,Object[] value) {
		super();
		this.key = key;
		this.value = value;
		this.map = new HashMap<>();
		for(int i =0;i< this.key.length; i++) {
			map.put(this.key[i], this.value[i]);
		}
	}
	
	public Object encode() {
		return this.map;
	}
	
	//message
	public static Map<String, Object> message(Boolean flag, Object message){
		status = new HashMap<>();
		if(flag) {
			status.put("code", 1);
			status.put("message", message);
			return status;
		}
		status.put("code", 0);
		status.put("message", message);
		return status;
	}
}
