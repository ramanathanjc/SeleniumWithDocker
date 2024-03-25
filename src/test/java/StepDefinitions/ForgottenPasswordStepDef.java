package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.opencart.pages.ForgetPassword;
import com.qa.opencart.pages.loginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ForgottenPasswordStepDef {
/*
	private WebDriver driver;
	private ForgetPassword forgetpwd;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		forgetpwd = new ForgetPassword(driver);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/forgotten");

	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	
	@Given("i want to check Forgot Password page Title")
	public void i_want_to_check_forgot_password_page_title() {
		String title =forgetpwd.getCurrentTitle();
		System.out.println("The Current Title name is :" +title);
		Assert.assertEquals(title, title);
	    
	}

	@Then("Enter the E-Mail Address box to reset")
	public void enter_the_e_mail_address_box_to_reset() {
		forgetpwd.enterEmail("testmail@gmail.com");
	}

	@Then("Check is instruction message visible ?")
	public void check_is_instruction_message_visible() {
	    
		String text = forgetpwd.Messagetext();
		System.out.println("Instruction Messgae is :"+text);
		Assert.assertEquals(text, text);
		
	}

	@Then("Click the Continue button")
	public void click_the_continue_button() {
		forgetpwd.clickContinuebtn();
	}
	
	*/
}
