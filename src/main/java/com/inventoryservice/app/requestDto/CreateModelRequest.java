package com.inventoryservice.app.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelRequest {
	@NotBlank
	@NotNull
	@Size(min = 2, max = 20)
	private String name;
	
	@NotBlank
	@NotNull
	private String brandId;
}