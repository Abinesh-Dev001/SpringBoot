package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	@Query(nativeQuery = true,value = "select * from usertab where name=(:name)")
	User getByUser(@Param("name") String username);

}
