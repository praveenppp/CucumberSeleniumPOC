package stepDefnition;

import java.io.IOException;


import com.aventstack.extentreports.Status;

import Base.BaseClass;
import PageClass.CreateSubscriptionPage;
import PageClass.InviteUsers;
import PageClass.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginScenario extends BaseClass
{
	
	    @Given("^Open the Chrome Browser and launch the KMD application$")				
	    public void open_the_Firefox_and_launch_the_application() throws Throwable							
	    {		
	    	setDriver("chrome","https://console-shareddev.kmdlogic.io/");
	    	test = extent.startTest("Verification of Login Functionality");
	    	LoginPage login = new LoginPage(driver,test); 
	    	login.VerifyPresenceofKMDADFS();
	    	login.clickKMDadfsButton();
	    }		

	    @When("^Enter Valid Username Password in Login Page$")			
	    public void Enter_Valid_Username_and_Password() throws Throwable 							
	    {		
	    	LoginPage login = new LoginPage(driver,test); 
	    	login.verifyCompanyLogo();
	    	login.enterUsername("PVV@kmd.dk");
	    	login.enterPassword("NewPassword@12n");
	    	login.clickSubmitButton();
	    	System.out.println("print");
	    	
	    }	
	    @Then("^Application should login Successfully$")
	    public void applicationShoulLogin() throws InterruptedException
	    {
	    	LoginPage login = new LoginPage(driver,test); 
	    	login.verifyCompanyLogoafterLogin();
	    }

	    @Given("^Login To KMD logic Application$")
	    public void loginToApplicaiton() throws InterruptedException, IOException
	    {
		
	    	
	    	setDriver("chrome","https://console-shareddev.kmdlogic.io/");
	    	test = extent.startTest("Verification of Add Subscription Functionality");
	    	//test.log(Status.INFO, "Opened Logic's App in Chrome Browser");
	    	LoginPage login = new LoginPage(driver,test); 
	    	login.VerifyPresenceofKMDADFS();
	    	login.clickKMDadfsButton();
//	    	ExtentManager.takeScreenShot(driver, test);
	        System.out.println("This Step open the Chrome and launch the application.");
	    	login.verifyCompanyLogo();
	    	login.enterUsername("PVV@kmd.dk");
	    	login.enterPassword("NewPassword@12n");
	    	login.clickSubmitButton();
	    	System.out.println("print");
	    
	    }
	    @When("^Clicked on Subscription tab and entered name in add subscription field and click on add subscription button.$")			
	    public void addSubscription() throws Throwable 							
	    {
	    	CreateSubscriptionPage sub = new CreateSubscriptionPage(driver, test);
	    	sub.clickSubscriptionTab();
	    	sub.clickADDSubscriptionTButton();
	    	sub.enterSubscriptionName("praveenSubscription");
	    	sub.clickCreateButton();
    	}	
	    @Then("^New Subscription should be added in the subscription list$")					
	    public void loginToApplication() throws Throwable 							
	    {    		
	    	CreateSubscriptionPage sub = new CreateSubscriptionPage(driver, test);
	    	sub.verifySubscriptionInList("praveenSubscription");
	    }
	    
	    @Given("^Login to KMD applicaition$")
	    public void openBrowserandLaunchApplication() throws InterruptedException, IOException
	    {
	    	setDriver("chrome","https://console-shareddev.kmdlogic.io/");
	    	test = extent.startTest("Verification of Invite User Functionality");
	    	//test.log(Status.INFO, "Opened Logic's App in Chrome Browser");

	    	LoginPage login = new LoginPage(driver,test); 
	    	login.VerifyPresenceofKMDADFS();
	    	login.clickKMDadfsButton();
	        System.out.println("This Step open the Chrome and launch the application.");
	    	
	    }
	    @When("^Enter Valid Username, Password and login to KMD application$")			
	    public void loginTokmdApplication() throws Throwable 							
	    {
	    	LoginPage login = new LoginPage(driver,test); 
	    	login.verifyCompanyLogo();
	    	login.enterUsername("PVV@kmd.dk");
	    	login.enterPassword("NewPassword@12n");
	    	login.clickSubmitButton();
	    }
	    @And("^Navigate to Users page and click on Invite User link$")
	    public void navigateToUsersPage() throws InterruptedException, IOException
	    {
	    	InviteUsers invite = new InviteUsers(driver,test);
	    	invite.hoverOnSubscriptionTab();
	    	invite.clickUserSubTab();
	    	invite.verifyUserPageIsDisplayed();
	    	invite.clickInviteUsersIcon();
	    	
	    	
	    }
	    @And("^Enter the Email ID and select the Role of the Inviting USER$")
	    public void enterInvitingEmailID() throws InterruptedException, IOException
	    {
	    	InviteUsers invite = new InviteUsers(driver,test);
	    	invite.enterInvitingEmailID("xyz@abcd.com");
	    	invite.clickOnSendButton();	  
	    	Thread.sleep(5000);
	    }
	    @Then("^Verify the Email ID entered for inviting is appearing in the list of Pending Invitations Page$")
	    public void verifyUserInvitedSuccesfully() throws InterruptedException, IOException
	    {
	    	InviteUsers invite = new InviteUsers(driver,test);
	    	invite.hoverOnSubscriptionTab();
	    	invite.clickPendingInvitesSubTab();
	    	invite.verifyDisplayOfPendingInvitesPage();
	    	invite.verifyInvitedEmailIDInList("ytujhgf@abcd.com");
	    	tearDown();
	    }
}
