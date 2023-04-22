package pomPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import frameworkUtils.FuncLibrary;

public class Shopclues_home extends FuncLibrary {

	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='What is on your mind today?']")
	WebElement search_field;
	
	@FindBy(xpath = "//a[@class='srch_action btn orange']")
	WebElement search_button;
	
	@FindBy(xpath = "//div[@id='product_list']/div[3]/div[1]")
	WebElement first_product;
	
	@FindBy(xpath = "//i[@id='instdcnt']")
	WebElement CountResult;
	
	
	public Shopclues_home(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void search_Products(String Productname) {
		
		enterText(search_field, Productname);
		
		eleClick(search_button);
		
	}
	
	public void clk_on_first_product() {
		
		eleClick(first_product);
	}
	
	public void search_product_using_Robot(String Productname) {
		
		enterText(search_field, Productname);
		
		try {
			Robot rb = new Robot();
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void count_the_result() {
		
		String result = getText(CountResult);
		
		
		
		int value = Integer.parseInt(result);
		
		if(!(value>0)){
			
			System.out.println("no result found for the entered Product");
			Reporter.log("the total results found for the search products are "+value);
			
		} else {
		
		System.out.println("the total results found for the search products are "+value);
		
		Reporter.log("the total results found for the search products are "+value);
		
		}
	}
	
	public void search_and_open(String Product) {
		
		search_Products(Product);
		
		sleep(2000);
		
		clk_on_first_product();
		
		sleep(2000);
	}
	
	public void searchAndcount(String Productname) {
		 
		search_product_using_Robot(Productname);
		
		
	}
	
}
