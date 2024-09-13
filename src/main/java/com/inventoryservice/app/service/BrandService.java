package com.inventoryservice.app.service;

import java.util.List;

import com.inventoryservice.app.requestDto.CreateBrandRequest;
import com.inventoryservice.app.requestDto.UpdateBrandRequest;
import com.inventoryservice.app.responseDto.CreateBrandResponse;
import com.inventoryservice.app.responseDto.GetAllBrandsResponse;
import com.inventoryservice.app.responseDto.GetBrandResponse;
import com.inventoryservice.app.responseDto.UpdateBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	CreateBrandResponse add(CreateBrandRequest createBrandRequest);
	UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);
	void delete(String id);
	GetBrandResponse getById(String id);
}