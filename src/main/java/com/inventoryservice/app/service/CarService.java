package com.inventoryservice.app.service;

import java.util.List;

import com.inventoryservice.app.requestDto.CreateCarRequest;
import com.inventoryservice.app.requestDto.UpdateCarRequest;
import com.inventoryservice.app.responseDto.CreateCarResponse;
import com.inventoryservice.app.responseDto.GetAllCarsResponse;
import com.inventoryservice.app.responseDto.GetCarResponse;
import com.inventoryservice.app.responseDto.UpdateCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	CreateCarResponse add(CreateCarRequest createCarRequest);
	UpdateCarResponse update(UpdateCarRequest updateCarRequest);
    GetCarResponse getById(String id);

	void delete(String id);
	void updateCarState(String carId, int state);

}

