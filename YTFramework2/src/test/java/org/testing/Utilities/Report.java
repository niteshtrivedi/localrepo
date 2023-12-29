package org.testing.Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class Report {

	public static ExtentReports HandleReport(){
		
		ExtentReports extentReport = new ExtentReports("D:\\Excelfiles\\reports.html",false);
		return extentReport;
	}
}
