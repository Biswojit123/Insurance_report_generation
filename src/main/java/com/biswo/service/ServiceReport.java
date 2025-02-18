package com.biswo.service;

import java.util.List;

import com.biswo.entity.CityzenPlanInfo;
import com.biswo.request.SearchData;

import jakarta.servlet.http.HttpServletResponse;

public interface ServiceReport {
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public List<CityzenPlanInfo> search(SearchData search);
	public boolean exportToExcel(HttpServletResponse reponse) throws Exception;
	public boolean exportToPdf(HttpServletResponse response)throws Exception;
}
