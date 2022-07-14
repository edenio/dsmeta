package com.devsuperior.dsmeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

	/*
	 * @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC"
	 * ) Page<Sales> findSales(LocalDate min, LocalDate max, Pageable pageable);
	 */
	
}
