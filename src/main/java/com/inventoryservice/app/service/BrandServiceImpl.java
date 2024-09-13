package com.inventoryservice.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inventoryservice.app.config.ModelMapperService;
import com.inventoryservice.app.exception.BusinessException;
import com.inventoryservice.app.kafka.InventoryProducer;
import com.inventoryservice.app.model.Brand;
import com.inventoryservice.app.repository.BrandRepository;
import com.inventoryservice.app.requestDto.CreateBrandRequest;
import com.inventoryservice.app.requestDto.UpdateBrandRequest;
import com.inventoryservice.app.responseDto.CreateBrandResponse;
import com.inventoryservice.app.responseDto.GetAllBrandsResponse;
import com.inventoryservice.app.responseDto.GetBrandResponse;
import com.inventoryservice.app.responseDto.UpdateBrandResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private InventoryProducer inventoryProducer;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandsResponse> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return response;
	}
	@Override
	public GetBrandResponse getById(String id) {
		checkIfBrandExistsById(id);
		Brand brand =brandRepository.findById(id).get();
		GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);
		return getBrandResponse;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {
		checkIfBrandExistsByName(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brand.setId(UUID.randomUUID().toString());

		this.brandRepository.save(brand);

		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
				CreateBrandResponse.class);
		return createBrandResponse;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);

		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand,
				UpdateBrandResponse.class);

		return updateBrandResponse;

	}
                                
	@Override
	public void delete(String id) {
		checkIfBrandExistsById(id);
		this.brandRepository.deleteById(id);

	}

	private void checkIfBrandExistsByName(String name) {
		Brand currentBrand = this.brandRepository.findByName(name);
		if (currentBrand != null) {
			throw new BusinessException("BRAND.EXISTS");
			
		}

	}

	private void checkIfBrandExistsById(String id) {
		var result = this.brandRepository.findById(id);
		if (result == null) {
			throw new BusinessException("BRAND.NO.EXISTS");
		}
	}
	
}
