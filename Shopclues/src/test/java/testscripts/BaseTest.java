package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import excelandreports.ExcelReader;
import frameworkUtils.DriverManager;
import frameworkUtils.FuncLibrary;
import frameworkUtils.FuncUtilLibrary;

public class BaseTest {
	
	WebDriver driver;
	
	String browsername;
	
	FuncLibrary func = new FuncLibrary();
	
	ExcelReader excel = new ExcelReader();
	
	DriverManager dm = new DriverManager();
	
	FuncUtilLibrary futil = new FuncUtilLibrary();
	
	

	
	@BeforeTest
	@Parameters({"browsername"})
	public void setUP(String browsername) {
		
     this.browsername = browsername;
        futil.loadProperties();
     try {
		driver = dm.setRemoteWebDriver(browsername);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
     
                   
		
}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		
		driver.quit();
	}
}
