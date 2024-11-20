package com.biswo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biswo.entity.CityzenPlanInfo;

public interface InsuranceRepository extends JpaRepository<CityzenPlanInfo, Integer> {
	//We have to create the two custom method to achieve our requirement 
	@Query("Select distinct(plan_name) from citizen_plans_info")
	public List<String> getPlanName();
	@Query("Select distinct(plan_status) from citizen_plans_info")
	public List<String> getPlanStatus();
}
