package com.example.demo.ResponseTemplate;

import org.springframework.http.HttpStatus;

public class APIresOut 
{
	private Integer StatusCode;
	private String Message;
	private Object Data;
	private Object Error;
	private Object[] Datas;
	
	
	public APIresOut()
	{
		super();
		this.StatusCode=HttpStatus.OK.value();
		this.Data=Data;
		this.Message=Message;
		this.Error=Error;
		this.Datas=Datas;
	}


	public Object[] getDatas() {
		return Datas;
	}


	public void setDatas(Object[] datas) {
		Datas = datas;
	}


	public Integer getStatusCode() {
		return StatusCode;
	}


	public void setStatusCode(Integer statusCode) {
		StatusCode = statusCode;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public Object getData() {
		return Data;
	}


	public void setData(Object data) {
		Data = data;
	}


	public Object getError() {
		return Error;
	}


	public void setError(Object error) {
		Error = error;
	}
}
