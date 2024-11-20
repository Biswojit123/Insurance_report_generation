package com.biswo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="citizen_plans_info")
public class CityzenPlanInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITYGEN_ID")
	private Integer cityzenId;
	@Column(name="CITYGEN_NAME")
	private String cityzenName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="PLAN_NAME")
	private String planName;
	@Column(name="PLAN_STATUS")
	private String planStatus;
	@Column(name="PLAN_STRAT_DATE")
	private LocalDate planStartDate;
	@Column(name="PLAN_END_DATE")
	private LocalDate planEndDate;
	@Column(name="BENFIT_AMOUNT")
	private Double benfitAmount;
	@Column(name="DENAIL_RESION")
	private String denailResion;
	@Column(name="TERMINATE_DATE")
	private LocalDate terminateDate;
	@Column(name="TERMINATE_RESION")
	private String terminationResion;
}
