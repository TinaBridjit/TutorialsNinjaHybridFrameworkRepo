package com.tutorialsninja.qa.utils;


	import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	import java.io.*;
	import java.util.Properties;
	public class ExtentReporter {
		public static ExtentReports GenerateExtentReport() 
		{
			ExtentReports extentreport=new ExtentReports();
			String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
			//File extentReportFile=new File(System.getProperty("user.dir")+"test-output\\extentReport.html");
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportPath);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setReportName("TUTORIALS NINJA TEST AUTOMATION RESULT REPORT");
			sparkReporter.config().setDocumentTitle("TN AUTOMATION RESULTS");
			sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
			
			extentreport.attachReporter(sparkReporter);
			Properties configprop=new Properties();
			File configpropfile=new File("config.properties");
			try {
			FileInputStream fis=new FileInputStream(configpropfile);
			configprop.load(fis);
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
			extentreport.setSystemInfo("Application URL", configprop.getProperty("url"));
			extentreport.setSystemInfo("Application browser name", configprop.getProperty("browser"));
			
			extentreport.setSystemInfo("Email", configprop.getProperty("validEmail"));
			extentreport.setSystemInfo("Password", configprop.getProperty("validpassword"));
			extentreport.setSystemInfo("Operating System", System.getProperty("os.name"));
			//extentreport.setSystemInfo("User Name", System.getProperty("user.name"));
			extentreport.setSystemInfo("Tested By", "Tina Bridjit Thomas");
			extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
			return extentreport;
			
		}

	}



