package com.example.demo.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Student;
import com.example.demo.Enum.Role;
import com.example.demo.ExceptionHandling.EmptyOrBlankValueNotAvailable;
import com.example.demo.ExceptionHandling.UserNotAvailable;
import com.example.demo.InputTemplate.StudentUpdateTemplate;
import com.example.demo.Repository.AddressRepo;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.ResponseTemplate.APIresOut;
import com.example.demo.Service.LogicBuild;

import java.util.List;

@Service
public class LogicBuildIMPL implements LogicBuild
{

	@Autowired
	public StudentRepo stuRepo;
	
	@Autowired
	public AddressRepo addRepo;
	
	@Override
	public APIresOut saveMethod(Student student) 
	{
		APIresOut api = new APIresOut();
		
		Student stuObj=new Student();
		//stuObj.setStudentId(student.getStudentId());
		stuObj.setName(student.getName());
		stuObj.setPassword(student.getPassword());
		stuObj.setAge(student.getAge());
		stuObj.setRole(student.getRole());
		stuObj.setGender(student.getGender());
		
		
		Address addObj = new Address();
		addObj.setDoorno(student.getAddress().getDoorno());
		addObj.setCity(student.getAddress().getCity());
		addObj.setState(student.getAddress().getState());
		addObj.setCountry(student.getAddress().getCountry());
		
		
		addObj=addRepo.save(addObj);
		
		stuObj.setAddress(addObj);
		
		stuObj=stuRepo.save(stuObj);
		
		api.setData(stuObj);
		api.setMessage("SUCCESS");
		api.setError("NO ERROR");
		api.setStatusCode(200);
		return api;
	}

	@Override
	public APIresOut deleteMethod(int id) throws UserNotAvailable
	{
		APIresOut api=new APIresOut();
		
		try
		{
		Student stuObj=stuRepo.getStudentDetails(id);
		
		if(stuObj!=null)
		{
			stuRepo.deleteById(id);
			api.setError(null);
			api.setMessage("Deleted");
			api.setStatusCode(200);
		}else {
			throw new UserNotAvailable("STUDENT NOT FOUND FOR THIS ID, CHECK IT AGAIN...");
		}
		
		}catch(UserNotAvailable e)
		{
			api.setError(e.getMessage());
			api.setMessage("CANNOT DELETED");
			api.setStatusCode(404);
		}
		
		
		return api;
	}

	@Override
	public APIresOut updateMethod(int studentId,StudentUpdateTemplate updateForm) throws UserNotAvailable,EmptyOrBlankValueNotAvailable
	{
		APIresOut api=new APIresOut();
		Student newStu=new Student();
		Address newAdd=new Address();
		
		try {
				Student stuObj=stuRepo.getStudentDetails(studentId);
				
				
				if(stuObj!=null)
				{
					try {
						if( !(updateForm.getName().isBlank()||updateForm.getName().isEmpty())
								&&!(updateForm.getPassword().isBlank()||updateForm.getPassword().isEmpty()) 
							&& (updateForm.getAge()!=0) )
						{
							newStu.setStudentId(stuObj.getStudentId());
							newStu.setName(updateForm.getName());
							newStu.setPassword(updateForm.getPassword());
							newStu.setAge(updateForm.getAge());
							newStu.setRole(updateForm.getRole());
							newStu.setGender(updateForm.getGender());
						}else {
							throw new EmptyOrBlankValueNotAvailable("Student Part(Name,Password,Age) This Fields Are Not Properly Filled. "
									+ "CHECK IT...");
						}
						
						if( !(updateForm.getDoorNo().isBlank()||updateForm.getDoorNo().isEmpty()) 
							&& !(updateForm.getCity().isBlank()||updateForm.getCity().isEmpty())
							&& !(updateForm.getState().isBlank()||updateForm.getState().isEmpty())
							&& !(updateForm.getCountry().isBlank()||updateForm.getCountry().isEmpty()) )
						{
							newAdd.setAddid(stuObj.getAddress().getAddid());
							newAdd.setDoorno(updateForm.getDoorNo());
							newAdd.setCity(updateForm.getCity());
							newAdd.setState(updateForm.getState());
							newAdd.setCountry(updateForm.getCountry());
					
							newAdd=addRepo.save(newAdd);
					
							newStu.setAddress(newAdd);
					
							newStu=stuRepo.save(newStu);
					
					
							api.setData(newStu);
							api.setMessage("Updateded SUCCESS");
							api.setError(null);
							api.setStatusCode(200);
						}else {
							throw new EmptyOrBlankValueNotAvailable("Address Part(DoorNo,City,State,Country) This Fields Are Not Properly Filled. "
									+ "CHECK IT...");
						}
					
					}catch(EmptyOrBlankValueNotAvailable e)
					{
						api.setError(e.getMessage());
						api.setData(null);
						api.setMessage("LAST CHANGE NOT UPDATED");
						api.setStatusCode(404);
					}
					
				}else if(stuObj==null){	
					System.out.println("Object is null so enter into 'else if' smt");
					throw new UserNotAvailable("CHECK THE STUDENT ID...");
				}
			 
		}catch(UserNotAvailable e)
		{
			api.setError(e.getMessage());
			api.setData(null);
			api.setMessage("LAST CHANGE NOT UPDATED");
			api.setStatusCode(404);
		}
		
		
		
		return api;
	}

	@Override
	public APIresOut listMethod() 
	{
		APIresOut api=new APIresOut();
		
		List<Student> stuList=stuRepo.findAll();
		Object[] arrList=stuList.toArray();
		
		api.setDatas(arrList);
		api.setError(null);
		api.setMessage("GET LIST");
		api.setStatusCode(200);
		return api;
	}

	@Override
	public APIresOut getByIdMethod(int id) throws UserNotAvailable 
	{
		APIresOut api=new APIresOut();
		try {
			
			Student stuObj=stuRepo.getStudentDetails(id);
			
			if(stuObj!=null)
			{
				api.setError(null);
				api.setData(stuObj);
				api.setMessage("GET DETAILS SUCCESSFULLY");
				api.setStatusCode(200);
			}else {
				throw new UserNotAvailable("STUDENT NOT FOUND FOR THIS ID, CHECK IT AGAIN...");
			}
			
		}catch(UserNotAvailable e)
		{
			api.setError(e.getMessage());
			api.setData(null);
			api.setMessage("CONNOT GET DETAILS");
			api.setStatusCode(404);
		}
		return api;
	}

}
