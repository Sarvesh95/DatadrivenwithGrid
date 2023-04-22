package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomPages.Shopclues_Login;

public class Login_Tests extends BaseTest {


 int Count = 1;

   @DataProvider(name="returnData")
	public Object[][] getData() {
	
	   XSSFSheet logindatasheet =	excel.getWorksheet(futil.readProperty("DataSheet"), futil.readProperty("LoginSheet"));
	   
	   System.out.println("The returned sheet is :"+logindatasheet);
	 int rowCount = excel.getRowCount(logindatasheet);
	 
	 System.out.println("Total rowCount is "+rowCount);
	 int colCount = excel.getColCount(logindatasheet);
	 
	 System.out.println("Total colCount is "+colCount);
	 
	 Object[][] data = new Object[rowCount-1][colCount-1];
	 for(int i = 1; i<rowCount; i++) {
		 for(int j = 1; j<colCount; j++) {
		 String Celldata= excel.readStringCell(logindatasheet, i, j); //assuming that the 1st row will be occupied for headers 
		                                                              // and 1st colomn  will be accupied for serial no.
		  
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
	

	
	@Test(dataProvider ="returnData")
	public void testExecution(String emailPhone) throws MalformedURLException {
	     
	 
		func.launchURL(driver);
	 
		Shopclues_Login sl = new Shopclues_Login(driver);
		
		String error_message = sl.log_in(emailPhone);
		
		System.out.println(error_message);
		
		Reporter.log(error_message);
	  /*	
		sendData(error_message, Count);
		
		Count++; */
		
		
	}
	
	
	
	public void sendData(String errorMessage, int index) {
		 XSSFSheet logindatasheet =	excel.getWorksheet(futil.readProperty("DataSheet"), futil.readProperty("LoginSheet"));
			excel.writeStringcell(logindatasheet, index, 2, errorMessage);
		
	}
}
