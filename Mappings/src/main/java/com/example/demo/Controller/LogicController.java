package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.ExceptionHandling.EmptyOrBlankValueNotAvailable;
import com.example.demo.ExceptionHandling.UserNotAvailable;
import com.example.demo.InputTemplate.StudentUpdateTemplate;
import com.example.demo.ResponseTemplate.APIresOut;
import com.example.demo.ServiceIMPL.LogicBuildIMPL;

@RestController
public class LogicController 
{
	@Autowired
	LogicBuildIMPL service;
	
	@PostMapping("save")
	public ResponseEntity<APIresOut> getsave(@RequestBody Student student)
	{
		APIresOut api = new APIresOut();
		api=service.saveMethod(student);
		return ResponseEntity.status(api.getStatusCode()).body(api);
	}
	
	@GetMapping("list")
	public ResponseEntity<APIresOut> getListStudent()
	{
		APIresOut api=new APIresOut();
		api=service.listMethod();
		return ResponseEntity.status(api.getStatusCode()).body(api);
		
	}
	
	@GetMapping("getDetail/{id}")
	public ResponseEntity<APIresOut> getDetailsById(@PathVariable("id") int id) throws UserNotAvailable
	{
		APIresOut api=new APIresOut();
		api=service.getByIdMethod(id);
		return ResponseEntity.status(api.getStatusCode()).body(api);
	}
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<APIresOut> getUpdate(@PathVariable("id") int id,@RequestBody StudentUpdateTemplate updateForm) throws UserNotAvailable,EmptyOrBlankValueNotAvailable
	{
		APIresOut api=new APIresOut();
		api=service.updateMethod(id, updateForm);
		return ResponseEntity.status(api.getStatusCode()).body(api);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<APIresOut> getDelete(@PathVariable("id") int id) throws UserNotAvailable
	{
		APIresOut api=new APIresOut();
		
		api=service.deleteMethod(id);
		
		return ResponseEntity.status(api.getStatusCode()).body(api);
	}
}
