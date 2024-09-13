package com.inventoryservice.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {

	@Id             
	@Column(name="id")
	private String id;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="state")// 1- Available 2-Under Maintenance 3-Rented
	private int state;
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
}