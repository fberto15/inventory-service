package com.curso.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curso.inventoryservice.model.Inventory;
import com.curso.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(100);
			inventory.setSkuCode("iphone13");
			
			Inventory inventory2 = new Inventory();
			inventory2.setQuantity(0);
			inventory2.setSkuCode("iphone 13 red");
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
		
	}

}
