package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtil;

public class ForgetPassword{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	By messageLoc = By.xpath("//div[@id='content']/p");
	By EmailIdLoc = By.name("email");
	By ClickContinue = By.xpath("//div/input[@type='submit']");
	
    public ForgetPassword(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }
    
    public String  getCurrentTitle() {
    	String title = driver.getTitle();
    	
    	return title;
    }
    
    public void enterEmail(String EmailId) {
    	WebElement EmailLocatior = eleUtil.getElement(EmailIdLoc, 5);
    	EmailLocatior.sendKeys(EmailId);
    }
    
    public void clickContinuebtn() {
    	WebElement Continuebtn =eleUtil.getElement(ClickContinue);
    	Continuebtn.click();
    }
    
    public String Messagetext() {	
    	WebElement message = eleUtil.getElement(messageLoc, 5);
    	String Inmsg = message.getText();
    	return Inmsg;
    	
    }


}
