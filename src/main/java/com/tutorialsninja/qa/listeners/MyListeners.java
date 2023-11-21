
	package com.tutorialsninja.qa.listeners;

	import org.openqa.selenium.WebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.tutorialsninja.qa.utils.ExtentReporter;
	import com.tutorialsninja.qa.utils.Utilities;

	public class MyListeners implements ITestListener{
		
		ExtentReports extentReport;
		ExtentTest extenttest;
		@Override
		public void onStart(ITestContext context) {
			 extentReport = ExtentReporter.GenerateExtentReport();
			
		}


		@Override
		public void onTestStart(ITestResult result) {
			String TestName=result.getName();
			extenttest = extentReport.createTest(TestName);
			extenttest.log(Status.INFO, TestName+"Started executing");
			
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			String TestName=result.getName();
			extenttest.log(Status.PASS, TestName+"got succesfully executed");
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
	        WebDriver driver = null;
	        
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
			String destinationScreenshotPath = Utilities.captureScreenshot(driver,result.getName());
			
			extenttest.addScreenCaptureFromPath(destinationScreenshotPath);
			extenttest.log(Status.INFO,result.getThrowable());
			extenttest.log(Status.FAIL,result.getName()+" got failed");
			
		}
		

		@Override
		public void onTestSkipped(ITestResult result) {
			
			
			extenttest.log(Status.INFO,result.getThrowable());
			extenttest.log(Status.SKIP, result.getName()+" got skipped");
		}

		
		@Override
		public void onFinish(ITestContext context) {
			extentReport.flush();
		
			/*String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}*/
			
		}

	}



