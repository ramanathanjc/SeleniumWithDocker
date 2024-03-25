package StepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.accountsPage;
import com.qa.opencart.pages.loginPage;
import com.qa.opencart.utilities.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageStepDef {

	private loginPage LoginPage = new loginPage(DriverFactory.getDriver());
	private accountsPage AccountsPage;
	
	private ConfigReader configReader;
	private Properties prop;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {

		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
		List<Map<String, String>> credList = dataTable.asMaps();

		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get(prop.getProperty("URL"));
		AccountsPage = LoginPage.doLogin(userName, password);

	}

	@When("user is on account page and should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		String title = AccountsPage.getAccountPageTilte();
		Assert.assertTrue(title.contains(expectedTitleName));
	}


	@Then("user get account section")
	public void user_get_account_section(DataTable headerTable) {
		List<String> expHeaderList = headerTable.asList();
		System.out.println("Expected Header List names :" + expHeaderList);

		List<String> actheaderList = AccountsPage.getHeaderList();
		System.out.println("Acutal Header List names :" + actheaderList);

		Assert.assertTrue(expHeaderList.containsAll(actheaderList));
	}

	@Then("Account section count shoul be {int}")
	public void account_section_count_shoul_be(Integer expHeaderCount) {

		Assert.assertTrue(AccountsPage.getHeaderCount() == expHeaderCount);
	}

}
