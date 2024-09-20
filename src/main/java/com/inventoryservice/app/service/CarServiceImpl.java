package com.inventoryservice.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.inventoryservice.app.config.ModelMapperService;
import com.inventoryservice.app.exception.BusinessException;
import com.inventoryservice.app.model.Car;
import com.inventoryservice.app.repository.CarRepository;
import com.inventoryservice.app.requestDto.CreateCarRequest;
import com.inventoryservice.app.requestDto.UpdateCarRequest;
import com.inventoryservice.app.responseDto.CreateCarResponse;
import com.inventoryservice.app.responseDto.GetAllCarsResponse;
import com.inventoryservice.app.responseDto.GetCarResponse;
import com.inventoryservice.app.responseDto.UpdateCarResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private ModelService modelService;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarsResponse> response = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		checkIfModelExistsByModelId(createCarRequest.getModelId());
		checkIfCarExistsByPlate(createCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		car.setId(UUID.randomUUID().toString());

		this.carRepository.save(car);

		CreateCarResponse createCarResponse = this.modelMapperService.forResponse().map(car, CreateCarResponse.class);
		
		return createCarResponse;
	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		checkIfModelExistsByModelId(updateCarRequest.getModelId());
		checkIfCarExistsById(updateCarRequest.getId());
		checkIfCarExistsByPlate(updateCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		car.setId(UUID.randomUUID().toString());

		this.carRepository.save(car);

		UpdateCarResponse updateCarResponse = this.modelMapperService.forResponse().map(car, UpdateCarResponse.class);
		return updateCarResponse;
	}

	@Override
	public GetCarResponse getById(String carId) {
		checkIfCarExistsById(carId);
        Car car = carRepository.findById(carId).orElseThrow();
        GetCarResponse response = modelMapperService.forResponse().map(car, GetCarResponse.class);

        return response;
    }
	
	@Override
	public void delete(String id) {
		checkIfCarExistsById(id);
		carRepository.deleteById(id);

	}

	private void checkIfCarExistsById(String id) {
		var result = carRepository.findById(id);
		if (result == null) {
			throw new BusinessException("CAR.NO.EXISTS");
		}
	}

	private void checkIfCarExistsByPlate(String plate) {
		var result = carRepository.findByPlate(plate);
		if (result != null) {
			throw new BusinessException("CAR.EXISTS");
		}
	}

			private void checkIfModelExistsByModelId(String modelId) {
		var result = modelService.getById(modelId);
		if (result == null) {
			throw new BusinessException("MODEL.NO.EXİSTS");
		}

	}

			@Override
			public void updateCarState(String carId,int state) {
			Car car= carRepository.findById(carId).get();
			car.setState(state);
			carRepository.save(car);
				
			}

			
		


}
