package configurations;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Webdriver implements ITestListener {
	SnapFunction sn = new SnapFunction();
//	ExcelSheet ec = new ExcelSheet();
	ExtentTest test;
	ExtentReports extent = ExtentReport.report_handler();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		String qw=""; 
		if(getDriver().toString().contains("Chrome")) {
			qw = "Chrome";}
		else if(getDriver().toString().contains("Edge")) {
			qw = "Edge";}
		else if(getDriver().toString().contains("firefox")) {
			qw = "Firefox";	}
		test = extent.createTest(result.getName()+"_"+qw);
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String qw= getDriver().toString().substring(0, 9);
//		String new1= result.getName()+""+qw;
		
		System.out.println("Test Passed: " + result.getName()+" "+qw);
		extentTest.get().log(Status.PASS, "Test Pass for " +" "+qw);
		try {
//			ec.updateResult(result.getName(), "Pass");
			extentTest.get().addScreenCaptureFromPath(sn.get_Screenshot(result.getName()+"_"+qw));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		String qw= getDriver().toString().substring(0, 9);
//		String new1= result.getName()+" "+qw;
		System.out.println("Test Failed: " + result.getName());
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "Test Failed for " + qw);
		try {
//			ec.updateResult(result.getName(), "Fail");
			extentTest.get().addScreenCaptureFromPath(sn.get_Screenshot(result.getName()+"_"+qw));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
}