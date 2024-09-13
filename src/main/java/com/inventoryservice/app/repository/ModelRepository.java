package com.inventoryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryservice.app.model.Model;

public interface ModelRepository extends JpaRepository<Model, String>{

}
