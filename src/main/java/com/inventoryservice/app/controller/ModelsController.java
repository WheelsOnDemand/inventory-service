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

import com.inventoryservice.app.requestDto.CreateModelRequest;
import com.inventoryservice.app.requestDto.UpdateModelRequest;
import com.inventoryservice.app.responseDto.CreateModelResponse;
import com.inventoryservice.app.responseDto.GetAllModelsResponse;
import com.inventoryservice.app.responseDto.GetModelResponse;
import com.inventoryservice.app.responseDto.UpdateModelResponse;
import com.inventoryservice.app.service.ModelService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;

	@GetMapping
	public List<GetAllModelsResponse> getAll() {
		return this.modelService.getAll();
	}

	@PostMapping
	public CreateModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest) {
		return this.modelService.add(createModelRequest);
	}

	@PutMapping
	public UpdateModelResponse update(@Valid @RequestBody UpdateModelRequest updateModelRequest) {
		return this.modelService.update(updateModelRequest);
	}

	@GetMapping("/{id}")
	public GetModelResponse getById(@PathVariable String id) {
		return this.modelService.getById(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.modelService.delete(id);
	}
}
