package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.locators.User2Locators;
import com.utility.HelperClass;

public class User2Actions {
	User2Locators user2Locators ;
	Actions act = new Actions(HelperClass.getDriver());
	JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
	public User2Actions() {
		this.user2Locators = new User2Locators();
		PageFactory.initElements(HelperClass.getDriver(), user2Locators);
	}
	public void  clickUserLogin() {
		user2Locators.login.click();
	}
	public void clickSignIn() {
		act.moveToElement(user2Locators.signIn).click().perform();
	}
	public void clickRadiology() {
		user2Locators.radiology.click();
	}
	public String verifyRadiology() {
		return user2Locators.assertRadiology.getText();
	}
	public void setBillNo(String Billno) {
		user2Locators.search1.sendKeys(Billno);
	}
	public void downloadPdf() {
		user2Locators.pdf.click();
	}
	public void clickAmbulance() {
		user2Locators.ambulance.click();
	}
	public String verifyAmbulance() {
		return user2Locators.assertAmbulance.getText();
	}
	public void clickPay() {
		user2Locators.pay.click();
	}
	public void clickAdd() {
		user2Locators.add.click();
	}
	public void clickPayCard() {
		user2Locators.payCard.click();
		HelperClass.getDriver().switchTo().frame(0);
	}
	public void setEmail(String Email){
		user2Locators.email.sendKeys(Email);
	}
	public void setCardNumber(String CardNumber) {
		user2Locators.cardNumber.sendKeys(CardNumber);	
	}
	public void setExpiry(String Expiry) {
		user2Locators.expiry.sendKeys(Expiry);
	}
	public void setCVC(String CVC) {
		user2Locators.cvc.sendKeys(CVC);
	}
	public void setzip(String zip) {
		user2Locators.zip.sendKeys(zip);
	}
	public void clickPayment() {
		wait.until(ExpectedConditions.elementToBeClickable(user2Locators.payment)).click();
//		bill.payment.click();
		HelperClass.getDriver().switchTo().parentFrame();
	}
	public void clickBloodBank() {
		user2Locators.bloodBank.click();
	}
	public void clickComponentIssue() {
		user2Locators.componentIssue.click();
	}
	public String verifyComponentIssue() {
		return user2Locators.assertComponentIssue.getText();
	}
	public void setComponent(String Component) {
		user2Locators.search2.sendKeys(Component);
	}
	public void clickWhatsApp() {
		user2Locators.whatsapp.click();
	}
	public void clickMember() {
		user2Locators.member.click();
	}
	public void setMessage(String Message) {
		user2Locators.message.sendKeys(Message);
		
	}
	public void clickButton() throws InterruptedException {
		Thread.sleep(5000);
		user2Locators.send.click();
	}
	public String setText() {
		return user2Locators.assertText.getText();
	}
	public void clickProfile() {
		user2Locators.profile.click();
	}
	public void clickLogOut() {
		user2Locators.logout.click();
	}
	
	public void actions(String BillNo,String Component,String Message,String CVC,String CardNumber,String Email,String zip,String Expiry) throws InterruptedException {
		this.setBillNo(BillNo);
		this.setComponent(Component);
		this.setMessage(Message);
		this.setCardNumber(CardNumber);
		this.setCVC(CVC);
		this.setEmail(Email);
		this.setExpiry(Expiry);
		this.setzip(zip);
	}
	
}
