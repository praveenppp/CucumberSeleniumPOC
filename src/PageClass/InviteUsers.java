package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import UtilityClass.ReportsUtility;

public class InviteUsers 
{
	public WebDriver driver;
	
	private By password = By.name("Password");
	private By signin = By.id("submitButton");
	
	
	
	
	private By userSubTab = By.xpath(".//span[text()='Users']/..");
	private By subscriptionsTab = By.xpath(".//a[@href='/subscriptions']");
	private By subscriptionSubTab = By.xpath(".//span[text()='Users']/../../../../..");
	private By userPageverification = By.xpath("//h6[@class='MuiTypography-root jss147 MuiTypography-h6 MuiTypography-colorInherit MuiTypography-noWrap']");
	private By inviteUserLogo = By.xpath(".//span[@class='MuiIconButton-label']");
	private By invitingEmail = By.name("emailAddress");
	private By sendButton = By.xpath(".//span[text()='Send']");
	private By confirmationMessageForSendingInvite = By.xpath(".//button[contains(text(),'KMD ADFS')]");
	private By pendingInvites = By.xpath(".//span[text()='Pending Invites']/..");
	private By pendingInvitesHeaderPage = By.xpath("//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-gutterBottom MuiTypography-alignCenter'][text()='Pending invitations']");
	
	private ExtentTest test ;
	ReportsUtility report = new ReportsUtility();
	public InviteUsers(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
//Hover on Subscription tab
	public boolean hoverOnSubscriptionTab() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(subscriptionsTab);
			
			
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				Actions actions = new Actions(driver);
				actions.moveToElement(signinbutton).perform();
				WebElement subtab = driver.findElement(subscriptionSubTab);
				if(subtab.isDisplayed())
				{
					test.log(LogStatus.PASS, "Subscription SubTabs Opened");
					System.out.println("Subscription SubTabs Opened");
					report.takeScreenShot(driver, test);
				}
				else {
					test.log(LogStatus.FAIL, "Hovered on Subscription but Subscription SubTabs Not Found");
					System.out.println("Hovered on Subscription but Subscription SubTabs Not Found");
					report.takeScreenShot(driver, test);
				}
			}
			else {
				test.log(LogStatus.FAIL, "Subscription Tabs Not Found");
				System.out.println("Subscription Tabs Not Found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Subscription SubTabs/Tab Not Found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
	
//Open Users Page
	public boolean clickUserSubTab() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(userSubTab);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on User SubTab");
				test.log(LogStatus.PASS, "Clicked on User SubTab");
			}
			else {
				test.log(LogStatus.FAIL, "User SubTab Not found");
				System.out.println("Failed to click on User SubTab");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "User SubTab NOT Found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}	
//Verify the user page is displayed
	public boolean verifyUserPageIsDisplayed() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(userPageverification);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Users Page is displayed -> "+signinbutton.getText());
				test.log(LogStatus.PASS, "Users Page is displayed");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "User page not found");
				System.out.println("User page not found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "User page not found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
	
//Click Invite Users Icon
	public boolean clickInviteUsersIcon() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(inviteUserLogo);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Invite user Logo");
				test.log(LogStatus.PASS, "Clicked on Invite user Logo");
			}
			else {
				test.log(LogStatus.FAIL, "Invite User Logo Not found");
				System.out.println("Invite User Logo Not found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Invite User Logo Not found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}	
	
//Enter Inviting User Email ID
	public boolean enterInvitingEmailID(String emailid) throws InterruptedException
	{
		try
		{
			WebElement emailText = driver.findElement(invitingEmail);
			if(emailText.isDisplayed()||emailText.isEnabled())
			{
				emailText.sendKeys(emailid);
				System.out.println("Entered Inviting Email ID");
				test.log(LogStatus.PASS, "Entered - "+emailid+" as Inviting Email ID");
				report.takeScreenShot(driver, test);
			}
			else { System.out.println("Failed to Enter Inviting Email ID");
			test.log(LogStatus.FAIL, "Failed To Enter Inviting Email ID");
			report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, " Inviting Email ID Field NOT found");
			report.takeScreenShot(driver, test);
			return false;
			
		}		
	}
	
//Select role for inviting user
	
	
//click on send button
	public boolean clickOnSendButton() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(sendButton);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Send Button");
				test.log(LogStatus.PASS, "Clicked on Send Button");
			}
			else {
				test.log(LogStatus.FAIL, "Send Button found");
				System.out.println("Send Button Not found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Failed to click on Send Button");
			report.takeScreenShot(driver, test);
			return false;
		}
	}	
	
//Verify the "Invitation has been sent" success notification 
	public boolean verifyConfirmationMessageforSendingInvite() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(confirmationMessageForSendingInvite);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Users Page is displayed -> "+signinbutton.getText());
				test.log(LogStatus.PASS, "Users Page is displayed");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "User page not found");
				System.out.println("User page not found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "User page not found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
	
//Open Pending Invitations page
	public boolean clickPendingInvitesSubTab() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(pendingInvites);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				signinbutton.click();
				System.out.println("Clicked on Pending Invites SubTab");
				test.log(LogStatus.PASS, "Clicked on Pending Invites SubTab");
			}
			else {
				test.log(LogStatus.FAIL, "Pending Invites SubTab Not found");
				System.out.println("Failed to click on Pending Invites SubTab");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Pending Invites SubTab NOT Found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}	
	
//Verify the display of Pending Invitations page
	public boolean verifyDisplayOfPendingInvitesPage() throws InterruptedException
	{
		try
		{
			WebElement signinbutton = driver.findElement(pendingInvitesHeaderPage);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Pending Invites Page is displayed -> "+signinbutton.getText());
				test.log(LogStatus.PASS, "Pending Invites Page is displayed");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Pending Invites page not found");
				System.out.println("Pending Invites page not found");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Pending Invites page not found");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
	
//Verify the presense of invited User in the list
	public boolean verifyInvitedEmailIDInList(String Invited_EmailID) throws InterruptedException
	{
		try
		{
			String xpath = " //span[text()='"+Invited_EmailID+"']";
			By subscription = By.xpath(xpath);
			WebElement signinbutton = driver.findElement(subscription);
			if(signinbutton.isDisplayed()||signinbutton.isEnabled())
			{
				System.out.println("Invited Email ID found in Pending Invitations list");
				test.log(LogStatus.PASS, "Invited Email ID found in Pending Invitations list");
				report.takeScreenShot(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Invited Email ID NOT found in Pending Invitations list");
				System.out.println("Invited Email ID NOT found in Pending Invitations list");
				report.takeScreenShot(driver, test);
			}
			return true;
		}
		catch (NoSuchElementException ignored){
			test.log(LogStatus.FAIL, "Invited Email ID NOT found in Pending Invitations list");
			report.takeScreenShot(driver, test);
			return false;
		}
	}
}
