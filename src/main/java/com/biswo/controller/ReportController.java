package com.biswo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.biswo.request.SearchData;
import com.biswo.service.ServiceReport;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	private ServiceReport service;
	
	@GetMapping("/excel")
	public void exportToExcel(HttpServletResponse response)throws Exception {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=users.xlsx");
		service.exportToExcel(response);
	}
	
	@GetMapping("/pdf")
	public void exportToPdf(HttpServletResponse response)throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=users.pdf");
		service.exportToPdf(response);
	}
	
	@PostMapping("/search") 
	public String handelSearch(@ModelAttribute("search")SearchData requestData,Model model) {
		System.out.println(requestData);
		model.addAttribute("plans", service.search(requestData));
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("search",new SearchData());
		init(model);
		return "index";
	}
	
	private void init(Model model) {
		model.addAttribute("name", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}
}
