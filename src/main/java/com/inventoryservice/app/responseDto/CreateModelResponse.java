package com.inventoryservice.app.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelResponse {
	private String id;
	private String name;
	private String brandId;
}
