package com.biswo.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.biswo.entity.CityzenPlanInfo;
import com.biswo.generate.EmailUtils;
import com.biswo.generate.ExportToExcel;
import com.biswo.generate.ExportToPdf;
import com.biswo.repo.InsuranceRepository;
import com.biswo.request.SearchData;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServiceReportImp implements ServiceReport {
	@Autowired
	private InsuranceRepository repo;
	
	@Autowired
	private ExportToPdf generatePdf;
	
	@Autowired
	private ExportToExcel generateExcel;
	
	@Autowired
	private EmailUtils emailSender;

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
	public boolean exportToExcel(HttpServletResponse response)throws Exception {
		
		//Create a File
		File f = new File("User.xls");
		List<CityzenPlanInfo> plans = repo.findAll();
		generateExcel.generateExcel(response, plans,f);
		
		//Here we send the excel file to mail
		//set the subject
		String subject = "Insurance Report";
		//set the email body
		String body = "<h1>Users Insurance Report File<h1>";
		//set the user mail id 
		String to = "jenabiswojit01@gmail.com";
		//call the method of JavaMailSender
		emailSender.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportToPdf(HttpServletResponse response)throws Exception {
		File f = new File("User.pdf");
		List<CityzenPlanInfo> plans = repo.findAll();
		generatePdf.generatePdf(response, plans,f);
		String subject = "Insurance Report";
		//set the email body
		String body = "<h1>Users Insurance Report File<h1>";
		//set the user mail id 
		String to = "jenabiswojit01@gmail.com";
		//call the method of JavaMailSender
		emailSender.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

}
