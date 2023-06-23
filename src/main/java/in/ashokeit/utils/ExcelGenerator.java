package in.ashokeit.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ashokeit.entity.CitizenPlan;
import in.ashokeit.repo.CitizenPlanRepository;

@Component
public class ExcelGenerator {
	
	
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {
		
		
		//With the below "XSSFWorkbook" implementation class the excel file extension will be .xlsx. 
		//Workbook workbook = new XSSFWorkbook(); 

		Workbook workbook = new HSSFWorkbook();
	    Sheet sheet = workbook.createSheet("plans-data");
	    Row headerRow = sheet.createRow(0);
		
	    headerRow.createCell(0).setCellValue("ID");
	    headerRow.createCell(1).setCellValue("Citizen Name");
	    headerRow.createCell(2).setCellValue("Plan Name");
	    headerRow.createCell(3).setCellValue("Plan Status");
	    headerRow.createCell(4).setCellValue("Plan Start date");
	    headerRow.createCell(5).setCellValue("Plan End Date");
	    headerRow.createCell(6).setCellValue("Benefit Amt");
	    
	   
	    
	    int dataRowIndex = 1;
	    
	    for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
	
			if(null != plan.getPlanStartDate()) {
					dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
			} else {
					dataRow.createCell(4).setCellValue("N/A");
			}
			if(null != plan.getPlanEndDate()) {
					dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if(null != plan.getBenefitAmt()) {
					dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			}else {
				    dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}
	    
		/*
		 * This logic is for the file to store in server.
		 * FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
		 * workbook.write(fos); workbook.close();
		 */
	    
	    //will send the file in email/current folder
	    FileOutputStream fos = new FileOutputStream(file);
	    workbook.write(fos);
	    fos.close();
	    
	    
	    //ServletOutputStream will send the file to the browser
	    ServletOutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    workbook.close();
	}
}
