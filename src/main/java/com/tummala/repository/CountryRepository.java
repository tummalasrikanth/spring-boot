package com.tummala.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tummala.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, QuerydslPredicateExecutor<Country>{
	
	@Query(value = "SELECT * FROM country c WHERE c.population = :population",
	        countQuery = "SELECT count(*) country c WHERE c.population = :population",
	        nativeQuery = true)
	Page<Country> findByPopulationNativeSQL(@Param("population") String population, Pageable pageable);

}
