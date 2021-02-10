package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.BaseClass;
import UtilityClass.ReportsUtility;

public class LoginPage extends BaseClass
{
	public WebDriver driver;
	private By email = By.name("UserName");
	private By password = By.name("Password");
	private By signin = By.id("submitButton");
	private By verifyProfileImage = By.xpath(".//*[@class='Header-link'][@aria-label='View profile and more']");
	private By KmdadfsButton = By.xpath(".//button[contains(text(),'KMD ADFS')]");
	private By companyLogo = By.id("companyLogo");
	private By logicLogo = By.xpath("//span[text()='Logic']");
	
	

	
	private ExtentTest test ;
	ReportsUtility report = new ReportsUtility();
	public LoginPage(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
//Entering Username
	public boolean enterUsername(String username) throws InterruptedException
	{
		try
		{
			WebElement emailText = driver.findElement(email);
			if(emailText.isDisplayed()||emailText.isEnabled())
			{
				emailText.sendKeys(username);
				System.out.println("Entered UserName");
				test.log(LogStatus.PASS, "Entered - "+username+" as Username");
				report.takeScreenShot(driver, test);
			}
			else { System.out.println("Failed to Enter Username");
			test.log(LogStatus.FAIL, "Failed To Enter UserName");
			report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, " UserName Name Field NOT found");
			report.takeScreenShot(driver, test);
			return false;
			
		}		
	}
//Entering Password	
	public boolean enterPassword(String pswd) throws InterruptedException
	{
		try
		{
			WebElement passwordtext = driver.findElement(password);
			if(passwordtext.isDisplayed()||passwordtext.isEnabled())
			{
				passwordtext.sendKeys(pswd);
				System.out.println("Entered Password");
				test.log(LogStatus.PASS, "Entered - "+pswd+" as Username");
				report.takeScreenShot(driver, test);
			}
			else
				{
				test.log(LogStatus.FAIL, "Entered - "+pswd+" as Username");
				System.out.println("Failed to enter Password");
				report.takeScreenShot(driver, test);
				}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Password Filed Not Found");
			report.takeScreenShot(driver, test);
			return false;
		}		
	}
//Clicking on Submit Button
	public boolean clickSubmitButton() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(signin);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Submit Button");
				test.log(LogStatus.PASS, "Clicked ON Submit Button");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Submit Button Not found");
				System.out.println("Failed to click on Submit Button");
				report.takeScreenShot(driver, test);
				
				Select drpCountry = new Select(driver.findElement(By.name("country"")));
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Login Button NOT Found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
//Verifying Company logo	
	public boolean verifyCompanyLogo()
	{
		try
		{
			WebElement signinbutton = driver.findElement(companyLogo);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Company Logo dislayed");
				test.log(LogStatus.PASS, "Company Logo dislayed");
			}
			else {
				test.log(LogStatus.FAIL, "Company Logo NOT found/dislayed");
				System.out.println("Company Logo NOT found/dislayed");
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Company Logo NOT found/dislayed");
			return false;
		}
	}
//Verifying Company logo	 
	public boolean verifyCompanyLogoafterLogin() throws InterruptedException
	{
		try
		{
			Thread.sleep(3000);
			WebElement signinbutton = driver.findElement(logicLogo);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Company Logo dislayed in HOME page, Hence LoggedIn Successfully");
				test.log(LogStatus.PASS, "Company Logo dislayed in HOME page, Hence LoggedIn Successfully");
			}
			else {
				test.log(LogStatus.FAIL, "Company Logo NOT found/dislayed in Home Page, Hence Login Failed");
				System.out.println("Company Logo NOT found/dislayed in Home Page, Hence Login Failed");
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Company Logo NOT found/dislayed in Home Page, Hence Login Failed");
			return false;
		}
	}
//click on KMD ADFS
	public boolean VerifyPresenceofKMDADFS() throws InterruptedException
	{
		try
		{
			WebElement kmdadfsButton = driver.findElement(KmdadfsButton);
			if(kmdadfsButton.isDisplayed()&&kmdadfsButton.isEnabled())
			{
				System.out.println("KMD ADFS Button is Displayed and Enabled");
				test.log(LogStatus.PASS, "KMD ADFS Button is Displayed and Enabled");
				report.takeScreenShot(driver, test);
			}
			else if(!kmdadfsButton.isDisplayed())
			{
				test.log(LogStatus.FAIL, "KMD ADFS Button is NOT Displayed");
				System.out.println("KMD ADFS Button is NOT Displayed");
				report.takeScreenShot(driver, test);
			}
			else if(kmdadfsButton.isDisplayed()&&!kmdadfsButton.isEnabled())
			{
				test.log(LogStatus.FAIL, "KMD ADFS Button is Displayed but NOT Enabled");
				System.out.println("KMD ADFS Button is Displayed but NOT Enabled");
				report.takeScreenShot(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "KMD ADFS Button is NOT Displayed and NOT Enabled");
				System.out.println("KMD ADFS Button is NOT Displayed and NOT Enabled");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "KMD ADFS Button NOT Found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
//clicking on KDM ADFS button
	public boolean clickKMDadfsButton() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(KmdadfsButton);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Submit Button");
				test.log(LogStatus.PASS, "Clicked ON Submit Button");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Submit Button Not found");
				System.out.println("Failed to click on Submit Button");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Login Button NOT Found");
			report.takeScreenShot(driver, test);
			return false;
			
		}
	}

}
