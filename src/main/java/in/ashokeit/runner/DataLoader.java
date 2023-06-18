package in.ashokeit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokeit.entity.CitizenPlan;
import in.ashokeit.repo.CitizenPlanRepository;

	@Component
	public class DataLoader implements ApplicationRunner {

		@Autowired
		private CitizenPlanRepository repo;
		
		@Override
		public void run(ApplicationArguments args) throws Exception {
			
			repo.deleteAll();
			
			// Cash plan Data
			CitizenPlan citizenPlan = new CitizenPlan();
			citizenPlan.setCitizenName("John");
			citizenPlan.setGender("Male");
			citizenPlan.setPlanName("Cash");
			citizenPlan.setPlanStatus("Approved");
			citizenPlan.setPlanStartDate(LocalDate.now());
			citizenPlan.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan.setBenefitAmt(5000.00);
			
			// Cash plan Data
			CitizenPlan citizenPlan1 = new CitizenPlan();
			citizenPlan1.setCitizenName("Smith");
			citizenPlan1.setGender("Male");
			citizenPlan1.setPlanName("Cash");
			citizenPlan1.setPlanStatus("Denied");
			citizenPlan1.setDenialReason("Rental Income");
			
			// Cash plan Data
			CitizenPlan citizenPlan2 = new CitizenPlan();
			citizenPlan2.setCitizenName("Cathy");
			citizenPlan2.setGender("Female");
			citizenPlan2.setPlanName("Cash");
			citizenPlan2.setPlanStatus("Terminated");
			citizenPlan.setPlanStartDate(LocalDate.now().minusMonths(4));
			citizenPlan.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan.setBenefitAmt(5000.00);
			citizenPlan.setTerminatedDate(LocalDate.now());
			citizenPlan.setTerminationRsn("Employed");
			
			// Food plan Data
			CitizenPlan citizenPlan3 = new CitizenPlan();
			citizenPlan3.setCitizenName("David");
			citizenPlan3.setGender("Male");
			citizenPlan3.setPlanName("Food");
			citizenPlan3.setPlanStatus("Approved");
			citizenPlan3.setPlanStartDate(LocalDate.now());
			citizenPlan3.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan3.setBenefitAmt(4000.00);
						
			// Food plan Data
			CitizenPlan citizenPlan4 = new CitizenPlan();
			citizenPlan4.setCitizenName("Robert");
			citizenPlan4.setGender("Male");
			citizenPlan4.setPlanName("Food");
			citizenPlan4.setPlanStatus("Denied");
			citizenPlan4.setDenialReason("Property Income");
						
			// Food plan Data
			CitizenPlan citizenPlan5 = new CitizenPlan();
			citizenPlan5.setCitizenName("Orlean");
			citizenPlan5.setGender("Female");
			citizenPlan5.setPlanName("Food");
			citizenPlan5.setPlanStatus("Terminated");
			citizenPlan5.setPlanStartDate(LocalDate.now().minusMonths(4));
			citizenPlan5.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan5.setBenefitAmt(5000.00);
			citizenPlan5.setTerminatedDate(LocalDate.now());
			citizenPlan5.setTerminationRsn("Employed");
			
			
			// Medical plan Data
			CitizenPlan citizenPlan6 = new CitizenPlan();
			citizenPlan6.setCitizenName("Charles");
			citizenPlan6.setGender("Male");
			citizenPlan6.setPlanName("Medical");
			citizenPlan6.setPlanStatus("Approved");
			citizenPlan6.setPlanStartDate(LocalDate.now());
			citizenPlan6.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan6.setBenefitAmt(4000.00);
									
			// Medical plan Data
			CitizenPlan citizenPlan7 = new CitizenPlan();
			citizenPlan7.setCitizenName("Buttler");
			citizenPlan7.setGender("Male");
			citizenPlan7.setPlanName("Medical");
			citizenPlan7.setPlanStatus("Denied");
			citizenPlan7.setDenialReason("Property Income");
									
			// Medical plan Data
			CitizenPlan citizenPlan8 = new CitizenPlan();
			citizenPlan8.setCitizenName("Neel");
			citizenPlan8.setGender("Female");
			citizenPlan8.setPlanName("Medical");
			citizenPlan8.setPlanStatus("Terminated");
			citizenPlan8.setPlanStartDate(LocalDate.now().minusMonths(4));
			citizenPlan8.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan8.setBenefitAmt(5000.00);
			citizenPlan8.setTerminatedDate(LocalDate.now());
			citizenPlan8.setTerminationRsn("Govt Job");
			
			// Employment plan Data
			CitizenPlan citizenPlan9 = new CitizenPlan();
			citizenPlan9.setCitizenName("Steve");
			citizenPlan9.setGender("Male");
			citizenPlan9.setPlanName("Employment");
			citizenPlan9.setPlanStatus("Approved");
			citizenPlan9.setPlanStartDate(LocalDate.now());
			citizenPlan9.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan9.setBenefitAmt(4000.00);
												
			// Employment plan Data
			CitizenPlan citizenPlan10 = new CitizenPlan();
			citizenPlan10.setCitizenName("Morris");
			citizenPlan10.setGender("Male");
			citizenPlan10.setPlanName("Employment");
			citizenPlan10.setPlanStatus("Denied");
			citizenPlan10.setDenialReason("Property Income");
												
			// Employment plan Data
			CitizenPlan citizenPlan11 = new CitizenPlan();
			citizenPlan11.setCitizenName("Gibbs");
			citizenPlan11.setGender("Female");
			citizenPlan11.setPlanName("Employment");
			citizenPlan11.setPlanStatus("Terminated");
			citizenPlan11.setPlanStartDate(LocalDate.now().minusMonths(4));
			citizenPlan11.setPlanEndDate(LocalDate.now().plusMonths(6));
			citizenPlan11.setBenefitAmt(5000.00);
			citizenPlan11.setTerminatedDate(LocalDate.now());
			citizenPlan11.setTerminationRsn("Govt Job");
			
			
			List<CitizenPlan> list = Arrays.asList(citizenPlan, citizenPlan1, citizenPlan2, 
										citizenPlan3, citizenPlan4, citizenPlan5,citizenPlan6, citizenPlan7, 
										citizenPlan8, citizenPlan9, citizenPlan10,citizenPlan11);
			
			repo.saveAll(list);
						
			
		}

}
