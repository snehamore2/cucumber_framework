package stepDefination;

import org.junit.Assert;

import com.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class steptest 

{
	private LoginPage ob=new LoginPage(DriverFactory.getDriver());
	public String title= "";
	
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get("https://trade.angelbroking.com/");
	}

	@When("User click on Login\\/Register")
	public void user_click_on_login_register() {
	    ob.login();
	}

	@Then("User Should redirect to Login Page")
	public void user_should_redirect_to_login_page() {
		title= ob.getTitle();
		System.out.println("login page title is.... :"+ title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
	  Assert.assertTrue(title.contains(string));
	}

	@Then("Forget password link should be displayed")
	public void forget_password_link_should_be_displayed() {
	  ob.isforgotlinkExit();
	}

	@Then("User enter Username {string}")
	public void user_enter_username(String string) {
	 ob.username(string);  
	}

	@Then("User enter Password {string}")
	public void user_enter_password(String string) {
	   ob.password(string);
	}

	@Then("Click on Login button")
	public void click_on_login_button() {
	   ob.signIn();
	}

	@Then("User should redirect to Portfolio Page")
	public void user_should_redirect_to_portfolio_page() {
	   title=ob.getTitle();
	   System.out.println("title of portfolio....."+title);
	   Assert.assertEquals(title,"Portfolio | Equity_New");
	   
	}

	
	
}
