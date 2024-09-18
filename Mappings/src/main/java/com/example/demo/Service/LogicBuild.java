package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.ExceptionHandling.EmptyOrBlankValueNotAvailable;
import com.example.demo.ExceptionHandling.UserNotAvailable;
import com.example.demo.InputTemplate.StudentUpdateTemplate;
import com.example.demo.ResponseTemplate.APIresOut;

public interface LogicBuild 
{
	public APIresOut saveMethod(Student student);
	public APIresOut listMethod();
	public APIresOut getByIdMethod(int id) throws UserNotAvailable; 
	public APIresOut updateMethod(int studentId,StudentUpdateTemplate updateForm) throws UserNotAvailable,EmptyOrBlankValueNotAvailable;
	public APIresOut deleteMethod(int id) throws UserNotAvailable;
}
