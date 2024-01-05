package com.curso.inventoryservice.service;

import java.util.List;

import com.curso.inventoryservice.dto.InventoryResponseDto;

public interface InventoryService {
	
	public List<InventoryResponseDto> isInStock(List<String> skuCodeList);

}
