package com.inventoryservice.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryservice.app.requestDto.CreateCarRequest;
import com.inventoryservice.app.requestDto.UpdateCarRequest;
import com.inventoryservice.app.responseDto.CreateCarResponse;
import com.inventoryservice.app.responseDto.GetAllCarsResponse;
import com.inventoryservice.app.responseDto.GetCarResponse;
import com.inventoryservice.app.responseDto.UpdateCarResponse;
import com.inventoryservice.app.service.CarService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
	private CarService carService;
	
	@GetMapping
	public List<GetAllCarsResponse> getAll(){
		return this.carService.getAll();
	}
	@PostMapping
	public CreateCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}	
	@PutMapping
	public UpdateCarResponse update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
		return this.carService.update(updateCarRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.carService.delete(id); 
	}
	@GetMapping("/{carId}")
	public GetCarResponse getById(@PathVariable String carId) {
		return this.carService.getById(carId);
	}
}
