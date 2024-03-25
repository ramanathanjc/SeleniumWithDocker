package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;

public class accountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By pageHeader = By.xpath("//div[@id='content']/h2");

	// Constructor
	public accountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public String getAccountPageTilte() {
		return eleUtil.getPageTitle();
	}

	public int getHeaderCount() {
		return eleUtil.waitForElementsVisible(pageHeader, 5).size();
	}

	public java.util.List<String> getHeaderList() {
		return eleUtil.getElementsTextList(pageHeader);

	}

}
