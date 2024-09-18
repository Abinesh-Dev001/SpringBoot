package com.example.demo.ServiceIMPL;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Questions;
import com.example.demo.Repository.QuestionsRepository;
import com.example.demo.Service.QuestionsService;

@Service
public class QuestionsServiceIMPL implements QuestionsService
{
	@Autowired
	public QuestionsRepository quesRepo;

	@Override
	public Questions saveLogicBuild(Questions questions) 
	{
		return quesRepo.save(questions);
	}

	@Override
	public List<Questions> getAllLogicBuild() {
		List<Questions> questions=quesRepo.findAll();
		return questions;
	}

	@Override
	public Questions GetByIdLogic(Long id) 
	{
		Questions details= quesRepo.getListByID(id);
		return details;
	}

	@Override
	public Questions updateFieldLogic(Long id,Questions question) {
		Questions details=quesRepo.getListByID(id);
		
		details.setId(id);
		details.setCategory(question.getCategory());
		details.setDifficultyLevel(question.getDifficultyLevel());
		details.setOption1(question.getOption1());
		details.setOption2(question.getOption2());
		details.setOption3(question.getOption3());
		details.setOption4(question.getOption4());
		details.setQuestionTitle(question.getQuestionTitle());
		details.setRightAnswer(question.getRightAnswer());
		
		
		return quesRepo.save(details);
	}

	@Override
	public Questions patchUpdate(Long id, Map<String, Object> update) 
	{
		Questions ques=quesRepo.getListByID(id);
		
		System.out.println("key value get :"+update.keySet());
		ques.setId(id);
		
	  for(String x :update.keySet())
	  {
		  System.out.println("x :"+x);
		  
		if(x.equals("category")) //1
		{
			String obj=(String) update.get(x);
			System.out.println("String value1 :"+obj);
			ques.setCategory(obj);
			
		}else if(x.equals("difficultyLevel")) //2
		{
			String obj=(String) update.get(x);
			System.out.println("String value2 :"+obj);
			ques.setDifficultyLevel(obj);
		}else if(x.equals("option1")) //3
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setOption1(obj);
		}else if(x.equals("option2")) //4
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setOption2(obj);
		}else if(x.equals("option3")) //5
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setOption3(obj);
		}else if(x.equals("option4")) //6
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setOption4(obj);
		}else if(x.equals("questionTitle")) //7
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setQuestionTitle(obj);
		}else if(x.equals("rightAnswer")) //8
		{
			String obj=(String) update.get(x);
			System.out.println("String value :"+obj);
			ques.setOption2(obj);
		}
		
	  }
			
		return quesRepo.save(ques);
	}

	@Override
	public String DeleteLogic(Long id) 
	{
		Questions q=quesRepo.getListByID(id);
		quesRepo.delete(q);
		return "ID is Deleted Successfully";
	}
	
	

}
