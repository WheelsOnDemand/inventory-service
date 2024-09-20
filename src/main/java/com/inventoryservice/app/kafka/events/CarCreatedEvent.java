package com.inventoryservice.app.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarCreatedEvent {
	private String message;
	private String carId;
	private String brandId;
	private String brandName;
	private String modelId;
	private String modelName;
	
}