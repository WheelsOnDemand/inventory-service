package com.inventoryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryservice.app.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {
	Brand findByName(String name);
}
