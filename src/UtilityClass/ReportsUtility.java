package UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.*;


public class ReportsUtility {
//	 String fileName = reportLocation + "extentreport.html";
public  ExtentReports extent ;

		public  ExtentReports getInstance() {
				Date d=new Date();
				String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
				String reportPath ="./Reports/ExtentReports/"+fileName;
//				htmlReporter = new ExtentHtmlReporter(filePath);
					extent = new ExtentReports(reportPath, false);

					extent
	                .addSystemInfo("Host Name", "Logic App")
	                .addSystemInfo("Environment", "Automation Testing")
	                .addSystemInfo("User Name", "Praveen");
					
					
//					extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
				extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
				// optional
//				extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo(
//						"Environment", CelcomConstants.ENV);
			return extent;
		}
		
// Method for taking screenshot
		public void takeScreenShot(WebDriver driver, ExtentTest test) throws InterruptedException
		{
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
			String filePath=System.getProperty("user.dir")+"//CucumberWithSelenium_simple//Reports//screenshots//"+screenshotFile;
			// store screenshot in that file
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			try 
			{
				FileUtils.copyFile(scrFile, new File(filePath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			System.out.println(filePath);
			test.log(LogStatus.INFO,test.addScreenCapture(filePath));
			Thread.sleep(2000);
		}
//	    public void FlushReport(){
//	        extent.flush();
//	    }
	    
	    
//method for extent config
//	    public void ExtentReport() {
//	        //First is to create Extent Reports
//	        extent = new ExtentReports();
//
//	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//	        htmlReporter.config().setTheme(Theme.DARK);
//	        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
//	        htmlReporter.config().setEncoding("utf-8");
//	        htmlReporter.config().setReportName("Test report");
//
//	        extent.attachReporter(htmlReporter);
//
//	    }

//	    public void ExtentReportScreenshot() throws IOException {
//
//	        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
//	        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
//	    }


		
}
