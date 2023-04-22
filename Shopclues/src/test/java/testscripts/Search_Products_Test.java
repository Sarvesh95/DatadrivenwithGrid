package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkUtils.DriverManager;
import pomPages.Shopclues_Productdetails;
import pomPages.Shopclues_home;

public class Search_Products_Test extends BaseTest {

	@Test(dataProvider = "receiveData" )
	public void testExecution(String Productname) {
	 
		func.launchURL(driver);
		
		
		Shopclues_home sh = new Shopclues_home(driver);
		Shopclues_Productdetails sp = new Shopclues_Productdetails(driver);
		sh.search_and_open(Productname);
	
		sp.get_productPriceandName();
		
		
		
	}
	
	
	
    @DataProvider(name = "receiveData")
	public Object[][] getdata() {
		
		 XSSFSheet logindatasheet =	excel.getWorksheet(futil.readProperty("DataSheet"), futil.readProperty("ProductSheet"));
		   
		   System.out.println("The returned sheet is :"+logindatasheet);
		 int rowCount = excel.getRowCount(logindatasheet);
		 
		 System.out.println("Total rowCount is "+rowCount);
		 int colCount = excel.getColCount(logindatasheet);
		 
		 System.out.println("Total colCount is "+colCount);
		 
		 Object[][] data = new Object[rowCount-1][colCount-1];
		 for(int i = 1; i<rowCount; i++) {
			 for(int j = 1; j<colCount; j++) {
			 String Celldata= excel.readStringCell(logindatasheet, i, j); //assuming that the 1st row will be occupied for headers 
			                                                              // and 1st coloumn  will be accupied for serial no.
			  
			 data[i-1][j-1] = Celldata;
		  }
		 }
		 try {
			excel.closeWorkbook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return data;
	}
}
