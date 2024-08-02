package com.crm.Listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.BaseClass.BaseClass;

public class BasicListner extends BaseClass implements ITestListener {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String t_name=result.getMethod().getMethodName();
		Reporter.log(t_name+" is executed");
		test=report.createTest(t_name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String t_name=result.getMethod().getMethodName();
		test.log(Status.PASS,t_name+" is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String t_name=result.getMethod().getMethodName();
		test.log(Status.FAIL,t_name+" is Fail");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String sreenshot=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(sreenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String t_name=result.getMethod().getMethodName();
		test.log(Status.SKIP,t_name+" is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		spark=new ExtentSparkReporter("./Reports/VtigerReports.html");
		spark.config().setDocumentTitle("SampleReport");
		spark.config().setReportName("TaskReport");
	
		report=new ExtentReports();
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
}
