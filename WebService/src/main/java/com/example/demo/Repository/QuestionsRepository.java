package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>{

	@Query(nativeQuery = true,value="select * from question where id=(:id)")
	Questions getListByID(@Param("id") Long id);

}
