package com.inventoryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryservice.app.model.Car;

public interface CarRepository extends JpaRepository<Car, String>{
	Car findByPlate(String plate);
}
