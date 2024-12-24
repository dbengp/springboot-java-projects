package com.system.takea_cab.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String pronouns;

	public Passenger() { }

	public Passenger(String name, String pronouns) {
		this.name = name;
		this.pronouns = pronouns;
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
}