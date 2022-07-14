package com.devsuperior.dsmeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.services.SalesServices;

@RestController
@RequestMapping(value = "/sales")
public class SalesControler {
	@Autowired
	private SalesServices service;
	
	@GetMapping
	public List<Sales> findSales(){
		
	return service.findSales();
		
	}

}
