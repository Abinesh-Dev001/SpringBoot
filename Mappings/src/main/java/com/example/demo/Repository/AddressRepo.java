package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
