package com.biswo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biswo.entity.CityzenPlanInfo;

@Repository
public interface InsuranceRepository extends JpaRepository<CityzenPlanInfo, Integer> {
	//We have to create the two custom method to achieve our requirement 
	@Query("Select Distinct(planName) from CityzenPlanInfo")
	public List<String> getPlanName();
	@Query("Select Distinct(planStatus) from CityzenPlanInfo")
	public List<String> getPlanStatus();
}
