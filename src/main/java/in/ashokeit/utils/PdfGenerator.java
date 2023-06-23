package in.ashokeit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokeit.entity.CitizenPlan;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File f) throws Exception {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		//PdfWriter.getInstance(document, new FileOutputStream(f));)
		document.open();
		/*
		 * Paragraph p = new Paragraph("Citizen plans Info"); document.add(p);
		 */
		
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		Paragraph paragraph = new Paragraph("Citizen plans Info", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		
		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(5);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		//table.addCell("Benefit Amt");
		
		
		
		for (CitizenPlan plan : plans) {
				table.addCell(String.valueOf(plan.getCitizenId()));
				table.addCell(plan.getCitizenName());
				table.addCell(plan.getPlanName());
				table.addCell(plan.getPlanStatus());
				table.addCell(plan.getPlanStartDate()+"");
				table.addCell(plan.getPlanEndDate()+"");
				//table.addCell(plan.getBenefitAmt()+"");
		}
		document.add(table);
		document.close();
		
	}
}
