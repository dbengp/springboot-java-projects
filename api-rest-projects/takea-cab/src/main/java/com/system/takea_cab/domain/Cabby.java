package com.system.takea_cab.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cabby {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String pronouns;
	String contact;

	//@OneToMany(mappedBy="cabby")
	//List<Car> cars;

	public Cabby() {}

	public Cabby(String name, String pronouns, String contact) {
		this.name = name;
		this.pronouns = pronouns;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPronouns() {
		return pronouns;
	}

	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
/*
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	} */
}
