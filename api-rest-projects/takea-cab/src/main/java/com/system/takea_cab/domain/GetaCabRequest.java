package com.system.takea_cab.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class GetaCabRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String wearehere;
	String wegoto;
	
	@ManyToOne
	Passenger passenger;
	
	@Enumerated(EnumType.STRING)
	GetaCabRequestStatus status;

	//@CreationTimestamp 
	LocalDateTime creationDate;

	public GetaCabRequest() { }

	public GetaCabRequest(Passenger passenger, String wearehere, String wegoto) {
		this.passenger = passenger;
		this.wearehere = wearehere;
		this.wegoto = wegoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWearehere() {
		return wearehere;
	}

	public void setWearehere(String wearehere) {
		this.wearehere = wearehere;
	}

	public String getWegoto() {
		return wegoto;
	}

	public void setWegoto(String wegoto) {
		this.wegoto = wegoto;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public GetaCabRequestStatus getStatus() {
		return status;
	}

	public void setStatus(GetaCabRequestStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public GetaCabRequest nowAndCreated(){
		setCreationDate(LocalDateTime.now());
		setStatus(GetaCabRequestStatus.CREATED);
		return this;
	}
}