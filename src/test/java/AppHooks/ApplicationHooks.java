package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order =0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		
	}
	@Before(order =1)
	public void LaunchBrowser()
	{
		String browserName= prop.getProperty("browser");
		System.out.println("BrowserName@@@@@@@@@@@@@@@@@@@@"+browserName);
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		
	}
	@After(order =0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void failTestScreenShot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String ScreenShotName=scenario.getName().replaceAll(" ","_");
			byte[] sourcePath =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", ScreenShotName);
		}
	}
	
}
