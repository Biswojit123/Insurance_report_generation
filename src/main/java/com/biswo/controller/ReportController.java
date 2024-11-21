package com.biswo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.biswo.service.ServiceReport;

@Controller
public class ReportController {
	
	@Autowired
	private ServiceReport service;
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
}
