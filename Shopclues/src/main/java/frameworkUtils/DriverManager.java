package frameworkUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

	WebDriver driver;
	public WebDriver setRemoteWebDriver(String browsername) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		switch (browsername) {
		
		case "chrome":
			
			dc.setBrowserName("chrome");
			
			break;
			
		case "firefox":
			
			dc.setBrowserName("firefox");
			
			break;
			
		case "edge":
			
			dc.setBrowserName("MicrosoftEdge");
			
			break;
			
		case "opera":
			
			dc.setBrowserName("opera");
			
			break;
			
		default:
			
			System.out.println("the browser mentioned is not valid");
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	    
		driver.manage().window().maximize();
		return driver;
		
	}
}
