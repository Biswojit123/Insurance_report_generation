package com.biswo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityzenPlanInfo> search(SearchData search) {
		// TODO Auto-generated method stub
		return null;
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
