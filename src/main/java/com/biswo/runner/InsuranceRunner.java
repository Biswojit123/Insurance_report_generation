package com.biswo.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.biswo.entity.CityzenPlanInfo;
import com.biswo.repo.InsuranceRepository;

@Component
public class InsuranceRunner implements ApplicationRunner {
	// Auto-wired the Repository layer
	@Autowired
	private InsuranceRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();

		// Create CitizenPlanInfo class
		CityzenPlanInfo citizen = new CityzenPlanInfo();
		// Cash plan
		citizen.setCityzenName("Jhon");
		citizen.setGender("Male");
		citizen.setPlanName("Cash");
		citizen.setPlanStatus("Approve");
		citizen.setPlanStartDate(LocalDate.now());
		citizen.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen.setBenfitAmount(5000.0);

		// Cash plan
		CityzenPlanInfo citizen1 = new CityzenPlanInfo();
		citizen1.setCityzenName("Bachan");
		citizen1.setGender("Male");
		citizen1.setPlanName("cash");
		citizen1.setPlanStatus("Denied");
		citizen1.setDenailResion("Adhar not sided with the bank passbook");

		// Cash plan
		CityzenPlanInfo citizen2 = new CityzenPlanInfo();
		citizen2.setCityzenName("Geeta");
		citizen2.setGender("Female");
		citizen2.setPlanName("cash");
		citizen2.setPlanStatus("Terminated");
		citizen2.setPlanStartDate(LocalDate.now().minusMonths(4));
		citizen2.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen2.setBenfitAmount(5000.0);
		citizen2.setTerminateDate(LocalDate.now());
		citizen2.setTerminationResion("Gov. employeed");

		// Create CitizenPlanInfo class
		CityzenPlanInfo citizen3 = new CityzenPlanInfo();
		// Food plan
		citizen3.setCityzenName("Kabita");
		citizen3.setGender("female");
		citizen3.setPlanName("Food");
		citizen3.setPlanStatus("Approve");
		citizen3.setPlanStartDate(LocalDate.now());
		citizen3.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen3.setBenfitAmount(8000.0);

		// Food plan
		CityzenPlanInfo citizen4 = new CityzenPlanInfo();
		citizen4.setCityzenName("Ritesh");
		citizen4.setGender("Male");
		citizen4.setPlanName("Food");
		citizen4.setPlanStatus("Denied");
		citizen4.setDenailResion("PAN card missing");

		// Food plan
		CityzenPlanInfo citizen5 = new CityzenPlanInfo();
		citizen5.setCityzenName("Chemi");
		citizen5.setGender("Female");
		citizen5.setPlanName("Food");
		citizen5.setPlanStatus("Terminated");
		citizen5.setPlanStartDate(LocalDate.now().minusMonths(2));
		citizen5.setPlanEndDate(LocalDate.now().plusMonths(4));
		citizen5.setBenfitAmount(6000.0);
		citizen5.setTerminateDate(LocalDate.now().minusDays(6));
		citizen5.setTerminationResion("Got job in Navy");

		CityzenPlanInfo citizen6 = new CityzenPlanInfo();
		// Medical plan
		citizen6.setCityzenName("Biswo");
		citizen6.setGender("Male");
		citizen6.setPlanName("Medical");
		citizen6.setPlanStatus("Approve");
		citizen6.setPlanStartDate(LocalDate.now().minusDays(20));
		citizen6.setPlanEndDate(LocalDate.now().plusMonths(5));
		citizen6.setBenfitAmount(10000.0);

		// Medical plan
		CityzenPlanInfo citizen7 = new CityzenPlanInfo();
		citizen7.setCityzenName("Rasmi");
		citizen7.setGender("Female");
		citizen7.setPlanName("Medical");
		citizen7.setPlanStatus("Denied");
		citizen7.setDenailResion("Many property");

		// Medical plan
		CityzenPlanInfo citizen8 = new CityzenPlanInfo();
		citizen8.setCityzenName("Bishnu");
		citizen8.setGender("Male");
		citizen8.setPlanName("Medical");
		citizen8.setPlanStatus("Terminated");
		citizen8.setPlanStartDate(LocalDate.now().minusMonths(5));
		citizen8.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen8.setBenfitAmount(6000.0);
		citizen8.setTerminateDate(LocalDate.now().minusDays(20));
		citizen8.setTerminationResion("Gov. employee");

		CityzenPlanInfo citizen9 = new CityzenPlanInfo();
		// Employment plan
		citizen9.setCityzenName("Dipti");
		citizen9.setGender("Female");
		citizen9.setPlanName("Employement");
		citizen9.setPlanStatus("Approve");
		citizen9.setPlanStartDate(LocalDate.now().minusDays(10));
		citizen9.setPlanEndDate(LocalDate.now().plusMonths(5));
		citizen9.setBenfitAmount(9000.0);

		// Employment plan
		CityzenPlanInfo citizen10 = new CityzenPlanInfo();
		citizen10.setCityzenName("Tusar");
		citizen10.setGender("Male");
		citizen10.setPlanName("Employment");
		citizen10.setPlanStatus("Denied");
		citizen10.setDenailResion("They Have won business");

		// Medical plan
		CityzenPlanInfo citizen11 = new CityzenPlanInfo();
		citizen11.setCityzenName("Chiki");
		citizen11.setGender("Female");
		citizen11.setPlanName("Employment");
		citizen11.setPlanStatus("Terminated");
		citizen11.setPlanStartDate(LocalDate.now().minusMonths(2));
		citizen11.setPlanEndDate(LocalDate.now().plusMonths(6));
		citizen11.setBenfitAmount(8000.0);
		citizen11.setTerminateDate(LocalDate.now().minusDays(15));
		citizen11.setTerminationResion("Gov. employeed");

		List<CityzenPlanInfo> list = Arrays.asList(citizen, citizen1, citizen2, citizen3, citizen4, citizen5, citizen5,
				citizen6, citizen7, citizen8, citizen9, citizen10, citizen11);
		//save object
		repo.saveAll(list);
	}

}
