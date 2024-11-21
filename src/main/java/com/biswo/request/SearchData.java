package com.biswo.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchData {
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate plan_start_date;
	private LocalDate plan_end_date;
}
