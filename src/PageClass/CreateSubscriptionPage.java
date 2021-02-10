package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import UtilityClass.ReportsUtility;

public class CreateSubscriptionPage
{
private ExtentTest test ;
public WebDriver driver;
private By SubscriptionsTab = By.xpath("//span[text()='Subscriptions']");
private By addSubscriptionButton = By.xpath("//span[text()=' Add Subscription']");
private By CreatesubscriptionHeaderText = By.className("//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-gutterBottom MuiTypography-alignCenter'][text()='Create Subscription']");
private By createSubscriptionTextField = By.xpath("//input[@class='MuiInputBase-input MuiInput-input']");
private By createButton = By.xpath("//span[@class='MuiButton-label'][text()='Create']");

//constructor
	public CreateSubscriptionPage(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	ReportsUtility report = new ReportsUtility();

//clicking on Subscription butotn
	public boolean clickSubscriptionTab()
	{
		try
		{
			WebElement signinbutton = driver.findElement(SubscriptionsTab);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Subscription Tab");
				test.log(LogStatus.PASS, "Clicked ON Subscription Tab");
			}
			else {
				test.log(LogStatus.FAIL, "Subscription Tab Not found");
				System.out.println("Failed to click on Subscription Tab");
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Subscription Tab NOT Found");
			return false;
		}
	}
//click on Add Subscription
	public boolean clickADDSubscriptionTButton()
	{
		try
		{
			WebElement signinbutton = driver.findElement(addSubscriptionButton);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Add Subscription Button");
				test.log(LogStatus.PASS, "Clicked ON Add Subscription Button");
			}
			else {
				test.log(LogStatus.FAIL, "Add Subscription Button Not found");
				System.out.println("Failed to click on Add Subscription Button");
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Add Subscription Button NOT Found");
			return false;
		}
	}
//Verify Create Subscription HeaderText

//Enter text in add subscription text field
	public boolean enterSubscriptionName(String subscriptionName) throws InterruptedException
	{
		try
		{
			WebElement emailText = driver.findElement(createSubscriptionTextField);
			if(emailText.isDisplayed()||emailText.isEnabled())
			{
				emailText.sendKeys(subscriptionName);
				System.out.println("Entered UserName");
				test.log(LogStatus.PASS, "Entered - \""+subscriptionName+"\" as Subscription NAME in Subscription text field");
				report.takeScreenShot(driver, test);
			}
			else { System.out.println("Failed to Enter Subscription NAME");
			test.log(LogStatus.FAIL, "Failed To Enter Subscription NAME");
			report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, " Subscription NAME text Field NOT found");
			report.takeScreenShot(driver, test);
			return false;
		}		
	}
//click on Create Button
	public boolean clickCreateButton()
	{
		try
		{
			WebElement signinbutton = driver.findElement(createButton);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Create Button");
				test.log(LogStatus.PASS, "Clicked ON Create Button");
			}
			else {
				test.log(LogStatus.FAIL, "Create Button Not found");
				System.out.println("Failed to click on Create Button");
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Create Button NOT Found");
			return false;
		}
	}
//Verify the subscription in list
	public boolean verifySubscriptionInList(String Subscription) throws InterruptedException
	{
		try
		{
			String xpath = "//tr[@class='MuiTableRow-root']/td[text()='"+Subscription+"']";
			By subscription = By.xpath(xpath);
			WebElement signinbutton = driver.findElement(subscription);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Subscrition created and found in subscription list");
				test.log(LogStatus.PASS, "Subscrition created and found in subscription list");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Subscription Name not found in list");
				System.out.println("Subscription Name not found in list");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Subscription Name not found in list");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
}
