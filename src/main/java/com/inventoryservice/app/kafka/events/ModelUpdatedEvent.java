package com.inventoryservice.app.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelUpdatedEvent {
	private String message;
	private String modelId;
	private String modelName;
	private String brandId;
	private String brandName;

}
