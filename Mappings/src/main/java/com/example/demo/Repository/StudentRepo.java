package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	
	@Query( nativeQuery = true,value="select * from student where student_id=:id")
	Student getStudentDetails(@Param("id") int studentId);

	@Query(nativeQuery = true,value="select * from student where name=:userName")
	Student getEveryDetails(@Param("userName") String username);
	
	

}
