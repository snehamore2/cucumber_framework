package stepDefination;

import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;

import java.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AccountPom;
import page.LoginPage;

public class AccountPage {

	private LoginPage page = new LoginPage(DriverFactory.getDriver());

	private AccountPom account;

	@Given("user already logged in to Application")
	public void user_already_logged_in_to_application(DataTable dataTable) {

		  List<Map<String,String>> credlist =dataTable.asMaps();
			String userName= credlist.get(0).get("username");
			String passWord=credlist.get(0).get("password");

			
			DriverFactory.getDriver().get("https://trade.angelbroking.com/Login");
			account= page.doLogin(userName, passWord);

	}

	@Given("user already logged in")
	public void user_already_logged_in() {
		String title = account.title();
		System.out.println("Title......" + title);

	}

	@Given("get all tab details")
	public void get_all_tab_details() {
			account.tabdetails();
			
	}

	@Then("verfiy all tab working")
	public void verfiy_all_tab_working() {
		Assert.assertTrue(account.dashboard());
		Assert.assertTrue(account.portfolio());
		Assert.assertTrue(account.market());
		Assert.assertTrue(account.order());
		Assert.assertTrue(account.advisory());
		Assert.assertTrue(account.fund());
		Assert.assertTrue(account.report());
		Assert.assertTrue(account.more());
	}

}
