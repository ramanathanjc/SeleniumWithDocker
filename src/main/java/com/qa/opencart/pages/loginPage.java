package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtil;

public class loginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	By emailLoc = By.id("input-email");
	By passwordLoc = By.id("input-password");
	By forgottenPasswordLinkLoc = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");
	By LoginBtnLoc = By.xpath("//input[@type='submit']");
	By message = By.xpath("(//div/p)[position()=3]");

	// Constructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void enterEmail(String Emailid) {

		WebElement emailinput = eleUtil.getElement(emailLoc, 5);
		emailinput.sendKeys(Emailid);

	}

	public void enterPassword(String password) {
		WebElement passwordInput = eleUtil.getElement(passwordLoc, 5);
		passwordInput.sendKeys(password);
	}

	public void clickloginBtn() {
		WebElement loginButton = eleUtil.getElement(LoginBtnLoc);
		loginButton.click();
	}

	public String getTheTitle() {
		return eleUtil.getPageTitle();

	}
	
	public String getMessage() {
		return eleUtil.doElementGetText(message);
	}

	public accountsPage doLogin(String email, String password) {
		System.out.println("Login with : " + email + " and : " +password );
		enterEmail(email);
		enterPassword(password);
		clickloginBtn();
		return new accountsPage(driver);
	}

}
