package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="address1")
public class Address 
{
	@Id
	@SequenceGenerator(name = "address_seq",sequenceName = "address_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_seq")
	@JsonIgnore
	private int addid;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private String doorno;
	
	@Column
	private String country;
	
	@OneToOne(mappedBy = "address")
	@JsonBackReference
	@JsonIgnore
	private Student student;

	public int getAddid() {
		return addid;
	}

	public void setAddid(int addid) {
		this.addid = addid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDoorno() {
		return doorno;
	}

	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address(String state, String city, String doorno, String country, Student student) {
		super();
		this.state = state;
		this.city = city;
		this.doorno = doorno;
		this.country = country;
		this.student = student;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
