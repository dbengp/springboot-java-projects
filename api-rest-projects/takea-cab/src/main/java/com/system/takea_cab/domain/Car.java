package com.system.takea_cab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Car {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCar;
    String licensePlate;
	String category;
	
    @ManyToOne
    @JoinColumn(name = "id")
    Cabby cabby;

    public Car() { }

    public Car(String licensePlate, String category) {
        this.licensePlate = licensePlate;
        this.category = category;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setId(Long idCar) {
        this.idCar = idCar;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Cabby getCabby() {
        return cabby;
    }

    public void setCabby(Cabby cabby) {
        this.cabby = cabby;
    }
}