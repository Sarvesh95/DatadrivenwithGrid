package testscripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import pomPages.Shopclues_home;

public class Search_and_Count extends BaseTest {

	@Test
	public void testExecution() {
		
		Shopclues_home sh = new Shopclues_home(driver);
		
		func.launchURL(driver);
		
		sh.search_product_using_Robot("Headphones");
		
		sh.count_the_result();
	}
}
