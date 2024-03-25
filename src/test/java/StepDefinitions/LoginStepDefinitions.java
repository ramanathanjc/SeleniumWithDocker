package StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.accountsPage;
import com.qa.opencart.pages.loginPage;
import com.qa.opencart.utilities.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinitions {

	private WebDriver driver;
	private loginPage loginpage = new loginPage(DriverFactory.getDriver());
	private ConfigReader configReader;
	Properties prop;
	
	//private ConfigReader configReader;
	
	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		DriverFactory.getDriver().get(prop.getProperty("URL"));
	}
	
	@When("I get the Page Title")
	public void i_get_the_page_title() {
		String title =loginpage.getTheTitle();
		System.out.println("The Page Title is :" +title);
		Assert.assertTrue(title.contains("Account Login"));
	}

	@Then("I get the message in login Page")
	public void i_get_the_message_in_login_page() {
		String msg =loginpage.getMessage();
		System.out.println("The Message is :" +msg);
		Assert.assertTrue(msg.contains("returning customer"));
	}

	@And("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
	
		loginpage.enterEmail(prop.getProperty("UserName".trim()));
		//loginpage.enterEmail("testram@gmail.com");
		//loginpage.enterPassword("Password@1");
		loginpage.enterPassword(prop.getProperty("Password".trim()));
		
	}
	
    @Then("I click on the login button")
    public accountsPage i_click_on_the_login_button() {
    	loginpage.clickloginBtn();
    	return new accountsPage(driver);
    }

   

}
