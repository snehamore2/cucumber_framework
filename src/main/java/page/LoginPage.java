package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage 
{
	public WebDriver driver;
	//Constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//By Locatores object repository
	private By Login=By.xpath("//a[@class='btn btn-color'][normalize-space()='LOGIN / REGISTER']");
	private By user=By.xpath("//input[@id='txtUserID']");
	private By password=By.xpath("//input[@id='txtTradingPassword']");
	private By signIn=By.xpath("//a[@id='loginBtn']");
	private By forgot=By.xpath("//div[@class='form-group text-center forgot_psw_link']//a[@class='link text-uppercase'][normalize-space()='Forgot password?']");
	
	public String getTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	public void login()
	{
		driver.findElement(Login).click();
	}
	public void username(String user)
	{
		driver.findElement(Login).sendKeys(user);
	}
	public void password(String pass)
	{
		driver.findElement(Login).sendKeys(pass);
	}
	public void signIn()
	{
		driver.findElement(signIn).click();
	}
	public boolean isforgotlinkExit()
	{
		return driver.findElement(forgot).isEnabled();
	}	
public AccountPom doLogin(String un, String pwd) {
		
		System.out.println("Login with username: " +un+ " and password "+ pwd);
		driver.findElement(user).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		
		return new AccountPom(driver);
		//	return ss;
		
		
	}
}

