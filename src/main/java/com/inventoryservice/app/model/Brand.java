package com.inventoryservice.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="brands")
public class Brand {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="brand")
	private List<Model> models;
}