package com.biswo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswo.entity.CityzenPlanInfo;

public interface InsuranceRepository extends JpaRepository<CityzenPlanInfo, Integer> {
	
}
