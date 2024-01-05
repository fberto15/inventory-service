package com.curso.inventoryservice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.inventoryservice.dto.InventoryResponseDto;
import com.curso.inventoryservice.repository.InventoryRepository;
import com.curso.inventoryservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	@Transactional(readOnly = true)
	public List<InventoryResponseDto> isInStock(List<String> skuCodeList) {
		return inventoryRepository.findBySkuCodeIn(skuCodeList).stream()
				.map(inventory -> InventoryResponseDto.of(inventory.getSkuCode(), inventory.getQuantity() > 0)).toList();
	}

}
