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

import com.inventoryservice.app.requestDto.CreateBrandRequest;
import com.inventoryservice.app.requestDto.UpdateBrandRequest;
import com.inventoryservice.app.responseDto.CreateBrandResponse;
import com.inventoryservice.app.responseDto.GetAllBrandsResponse;
import com.inventoryservice.app.responseDto.GetBrandResponse;
import com.inventoryservice.app.responseDto.UpdateBrandResponse;
import com.inventoryservice.app.service.BrandService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {               //entity,data access,request,response,abstract service,concrete manager,controller
	private BrandService brandService;
	
	@GetMapping
	public List<GetAllBrandsResponse> getAll(){
		return this.brandService.getAll();
	}
	
	@PostMapping
	public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}
	@PutMapping
	public UpdateBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest); 
	}
	@GetMapping("/{id}")
	public GetBrandResponse getById(@PathVariable String id) {
		return this.brandService.getById(id);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {  //rootbalancing yük dengeleme yapılır.//gateway kurunca diğer servisleri artık çağırabiliriz.
		 this.brandService.delete(id);
	}
	
	
}
