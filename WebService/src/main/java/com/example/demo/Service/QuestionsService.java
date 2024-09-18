package com.example.demo.Service;

import com.example.demo.Entity.Questions;

import java.util.List;
import java.util.Map;

public interface QuestionsService 
{
	public Questions saveLogicBuild(Questions questions);
	public List<Questions> getAllLogicBuild();
	public Questions GetByIdLogic(Long id);
	public Questions updateFieldLogic(Long id,Questions question);
	public Questions patchUpdate(Long id,Map<String,Object> update);
	public String DeleteLogic(Long id);
}
