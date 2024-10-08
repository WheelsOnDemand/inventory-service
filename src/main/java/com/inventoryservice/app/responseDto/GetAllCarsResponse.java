package com.inventoryservice.app.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {
	
	private String id;
	private double dailyPrice;
	private int modelYear;
	private String plate;
	private String brandName;
	private String colorName; 
	private int state;
}
