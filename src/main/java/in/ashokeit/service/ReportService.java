package in.reports.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.reports.entity.CitizenPlan;
import in.reports.request.SearchRequest;

public interface ReportService {

		public List<String> getPlanNames();
		
		public List<String> getPlanStatuses();
		
		public List<CitizenPlan> search(SearchRequest request);
		
		public boolean exportExcel(HttpServletResponse response) throws Exception;
		
		public boolean exportPdf(HttpServletResponse response) throws Exception;
		
}
