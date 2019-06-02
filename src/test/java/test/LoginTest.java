package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.Xls_Reader;

public class LoginTest {
	
	Xls_Reader reader =new Xls_Reader(".//Data//testdata.xlsx");
	
	String url = reader.getCellData("Sheet1", "url", 2);
	String userName = reader.getCellData("Sheet1", "UserName", 2);
	String password = reader.getCellData("Sheet1", "Password", 2);;
	
	@Test
	public void loginTest() {
		
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
//		WebDriver driver = BrowserFactory.startBrowser(url);
//		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//		loginPage.login(userName, password);
	}
}