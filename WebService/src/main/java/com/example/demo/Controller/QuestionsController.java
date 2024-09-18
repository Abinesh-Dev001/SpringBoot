package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Questions;
import com.example.demo.ServiceIMPL.QuestionsServiceIMPL;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionsController 
{
	@Autowired
	public QuestionsServiceIMPL questionService;
	
	@PostMapping("save")
	public Questions saveMethod(@RequestBody Questions questions)
	{
		return questionService.saveLogicBuild(questions);
	}
	
	@GetMapping("list")
	public List<Questions> getListDetails()
	{
		return questionService.getAllLogicBuild();
	}
	
	@GetMapping("getId/{id}")
	public Questions getDetails(@PathVariable("id") Long id)
	{
		return questionService.GetByIdLogic(id);
	}
	
	@PutMapping("putList/{id}")
	public Questions updateMethod(@PathVariable("id") Long id,@RequestBody Questions question)
	{
		return questionService.updateFieldLogic(id, question);
	}
	
	@PatchMapping("patchList/{id}")
	public Questions patchUpdate(@PathVariable("id") Long id,@RequestBody Map<String, Object> update)
	{
		return questionService.patchUpdate(id, update);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteMethod(@PathVariable("id") Long id)
	{
		return questionService.DeleteLogic(id);
	}
}
