Feature: Sample Cucumber Framework for Logic App

  @SmokeTest
  Scenario: Verification of Login Functionality
    Given Open the Chrome Browser and launch the KMD application
    When Enter Valid Username Password in Login Page
    Then Application should login Successfully


 @RegressionTest
  Scenario: Verification of Add Subscription Functionality
    Given Login To KMD logic Application
    When Clicked on Subscription tab and entered name in add subscription field and click on add subscription button.
    Then New Subscription should be added in the subscription list

  @smoke
  Scenario: Verification of Invite User Function
    Given Login to KMD applicaition
    When Enter Valid Username, Password and login to KMD application
    And Navigate to Users page and click on Invite User link
    And Enter the Email ID and select the Role of the Inviting USER
    Then Verify the Email ID entered for inviting is appearing in the list of Pending Invitations Page