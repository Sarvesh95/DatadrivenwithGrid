package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import frameworkUtils.FuncLibrary;

public class Shopclues_Productdetails extends FuncLibrary{

	WebDriver driver ;
	
	@FindBy(xpath = "//h1")
	WebElement product_name;
	
	@FindBy(xpath = "//span[@class='f_price']")
	WebElement product_price; 
	
	public Shopclues_Productdetails(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	
	}
	
	public void get_productPriceandName() {
		
		switch_to_Tab(driver, 1);
		
		String productName = getText(product_name);
		
		Reporter.log("product name: "+productName);
		
		String productPrice = getText(product_price);
		
		Reporter.log("product price :"+productPrice);
		
		driver.close();
		
		switch_to_Tab(driver, 0);
		
	}
	
}