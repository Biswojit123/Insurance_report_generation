package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.biswo.entity.CityzenPlanInfo;
import com.biswo.repo.InsuranceRepository;
import com.biswo.request.SearchData;

@Service
public class ServiceReportImp implements ServiceReport {
	@Autowired
	private InsuranceRepository repo;

	@Override
	public List<String> getPlanName() {
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CityzenPlanInfo> search(SearchData search) {
		//Create the CityzenPlanInfo object to pass example object
		CityzenPlanInfo info = new CityzenPlanInfo();
		//set the Search data to the info object according to the search criteria
		if(null != search.getPlanName() && !"".equals(search.getPlanName())) {
			info.setPlanName(search.getPlanName());
		}
		
		if(null != search.getPlanStatus() && !"".equals(search.getPlanStatus())) {
			info.setPlanStatus(search.getPlanStatus());
		}
		
		if(null != search.getGender() && !"".equals(search.getGender())) {
			info.setGender(search.getGender());
		}
		
		if(null != search.getPlan_start_date()) {
			info.setPlanStartDate(search.getPlan_start_date());
		}
		
		if(null != search.getPlan_end_date()) {
			info.setPlanEndDate(search.getPlan_end_date());
		}
		return repo.findAll(Example.of(info));
	}

	@Override
	public boolean exportToExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportToPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
