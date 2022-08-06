package com.dj.yyds.config;

// mvn page
public class ResultModel {

	private Integer code;
	private String msg;
	private Object data;

	
	public static ResultModel success() {
		return new ResultModel(200, "success", null);
	}
	
	public static ResultModel success(Object data) {
		return new ResultModel(200, "success", data);
	}
	
	public static ResultModel success(String msg, Object data) {
		return new ResultModel(200, msg, data);
	}
	
	public static ResultModel error() {
		return new ResultModel(-1, "系统处理异常", null);
	}

	public static ResultModel error(String msg) {
		return new ResultModel(-1, msg, null);
	}
	
	public static ResultModel error(String msg, Object data) {
		return new ResultModel(-1, msg, data);
	}

	public static ResultModel error(Integer code, String msg) {
		return new ResultModel(code, msg);
	}
	
	public ResultModel(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultModel(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
