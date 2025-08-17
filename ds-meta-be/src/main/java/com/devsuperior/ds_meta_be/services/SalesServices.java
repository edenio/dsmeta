package com.devsuperior.ds_meta_be.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.ds_meta_be.entities.Sales;
import com.devsuperior.ds_meta_be.repository.SalesRepository;

@Service
public class SalesServices {
	@Autowired
	private SalesRepository repository;
	
	public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
		
	}

}
