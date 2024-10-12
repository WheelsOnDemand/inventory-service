package com.inventoryservice.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.inventoryservice.app.kafka.events.CarCreatedEvent;
import com.inventoryservice.app.kafka.events.RentalCreatedEvent;
import com.inventoryservice.app.kafka.events.RentalUpdatedEvent;
import com.inventoryservice.app.service.CarService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalConsumer { 
	private CarService carService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RentalConsumer.class);

	@KafkaListener(topics = "rental-created", groupId = "rental-create")
	public void consume(RentalCreatedEvent event) {
		LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));

		carService.updateCarState(event.getCarId(),3);

		// save the order event into the database
	}
	@KafkaListener(topics = "rental-updated", groupId = "update")
	public void consume(RentalUpdatedEvent event) {
		LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
		carService.updateCarState(event.getOldCarId(), 1);
		carService.updateCarState(event.getNewCarId(), 3); 
	}
}
