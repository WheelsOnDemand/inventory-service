package com.inventoryservice.app.service;

import java.util.List;

import com.inventoryservice.app.requestDto.CreateModelRequest;
import com.inventoryservice.app.requestDto.UpdateModelRequest;
import com.inventoryservice.app.responseDto.CreateModelResponse;
import com.inventoryservice.app.responseDto.GetAllModelsResponse;
import com.inventoryservice.app.responseDto.GetModelResponse;
import com.inventoryservice.app.responseDto.UpdateModelResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	CreateModelResponse add(CreateModelRequest createModelRequest);
	UpdateModelResponse update(UpdateModelRequest updateModelRequest);
	void delete(String id);
	GetModelResponse getById(String id);
}
