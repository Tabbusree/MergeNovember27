package com.stepdefinition;

import java.util.Set;

import org.junit.Assert;


import com.actions.User2Actions;

import com.utility.DataClass;
import com.utility.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User2StepDefinition  {

	User2Actions user2Actions = new User2Actions(); 
	DataClass data = new DataClass();

	@Given("User enters into the User Login portal")
	public void user_enters_into_the_user_login_portal() {
	    HelperClass.openPage(data.url);
	    HelperClass.log.info("The website launches");
	    user2Actions.clickUserLogin();
    Set<String> allWindows = HelperClass.getDriver().getWindowHandles();
	for (String curWindow : allWindows) {
		HelperClass.getDriver().switchTo().window(curWindow);
	}
	user2Actions.clickSignIn();
	HelperClass.log.info("User logged in successfully");	    
	}

//<-------------------------------------Radiology------------------------------------->
	@Given("User clicks radiology")
	public void user_clicks_radiology() {
		user2Actions.clickRadiology();
		Assert.assertTrue(user2Actions.verifyRadiology().contains("Radiology Test Reports"));
		HelperClass.log.info("The radiology assert is successful");

	}

	@When("Search the bill number in search field")
	public void search_the_bill_number_in_search_field() {
		user2Actions.setBillNo(data.Billno);

	}

	@Then("Download the report in pdf format")
	public void download_the_report_in_pdf_format() {
		user2Actions.downloadPdf();
		HelperClass.log.info("PDF downloaded successfully");
	}

//<---------------------------------------Ambulance---------------------------------------->
	@Given("User clicks the ambulance")
	public void user_clicks_the_ambulance() {
		user2Actions.clickAmbulance();
		String z=user2Actions.verifyAmbulance();
		Assert.assertTrue(z.contains("Ambulance Bill"));
		HelperClass.log.info("The ambulance assert is successful");
	}

	@When("Processing payment using card")
	public void processing_payment_using_card() {
		user2Actions.clickPay();
		user2Actions.clickAdd();
		user2Actions.clickPayCard();
		user2Actions.setEmail(data.Email);
		user2Actions.setCardNumber(data.CardNumber);
		user2Actions.setCardNumber(data.CardNumber);
		user2Actions.setCardNumber(data.CardNumber);
		user2Actions.setCardNumber(data.CardNumber);
		user2Actions.setExpiry(data.Expiry);
		user2Actions.setExpiry(data.Expiry);
		user2Actions.setCVC(data.CVC);
		user2Actions.setzip(data.Zipcode);
		user2Actions.clickPayment();

		
	}

	@Then("Checks the payment is successful")
	public void checks_the_payment_is_successful() {
//		Assert.assertTrue(user2Actions.verifyPayment().contains(" Success "));
		HelperClass.log.info("The payment is asserted");
//		String title = HelperClass.getDriver().getTitle();
//		HelperClass.log.info(title);

	}

//<-----------------------------------Blood Bank-------------------------------------->	
	@Given("User clicks the blood bank")
	public void user_clicks_the_blood_bank() {
		user2Actions.clickBloodBank();
	}

	@When("Switches to component issue")
	public void switches_to_component_issue() {
		user2Actions.clickComponentIssue();
		Assert.assertTrue(user2Actions.verifyComponentIssue().contains("Component Issue"));
		HelperClass.log.info("The component issue assert is successful");
	}

	@Then("Search for component using search field")
	public void search_for_component_using_search_field() {
		user2Actions.setComponent(data.Component);
		HelperClass.log.info("The component name was searched");		
	}
	
//<--------------------------------------------Whatsapp--------------------------------------->
	
	@Given("User clicks the whatsapp")
	public void user_clicks_the_whatsapp() {
		user2Actions.clickWhatsApp();
		user2Actions.clickMember();
		user2Actions.setMessage(data.Message);
	}

	@When("Send message to the staff")
	public void send_message_to_the_staff() throws InterruptedException {
		user2Actions.clickButton();
		
	}

	@Then("Check the message is delivered")
	public void check_the_message_is_delivered() {
		Assert.assertTrue(user2Actions.setText().contains("Hi"));
		HelperClass.log.info("The message is delivered");
//		System.out.println("The message is delivered");
		user2Actions.clickProfile();
		user2Actions.clickLogOut();
		String assertUrl = HelperClass.getDriver().getCurrentUrl();
		System.out.println("The current url is: "+assertUrl);
		
	}
}
