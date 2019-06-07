package test;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddExpensePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddExpenseTest {
	@Test
	
	public void addExpenseTest() {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");

		// activate the dashboard Page
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// validate dashboard page
		dashboardPage.WaitForPage();

		// click of AddExpense button
		dashboardPage.clickOnAddExpenseButton();

		// activate the AddExpense Page
		AddExpensePage addExpensePage = PageFactory.initElements(driver, AddExpensePage.class);
		// validate addExpense page
		addExpensePage.WaitForPage();

		addExpensePage.selectFromDropDownForExpense("AutoAccount");

		addExpensePage.clearTheDateAndInput("2019-05-29");
		
		addExpensePage.clickAway();


		Random rnd = new Random();
		String ExpenseDescription = ("Rent") + String.valueOf(rnd.nextInt(999));
		String ExpenseAmount = String.valueOf(rnd.nextInt(1500));
		
		
		addExpensePage.inputExpenseDescriptionAndAmount(ExpenseDescription,ExpenseAmount);
		
		addExpensePage.SubmitButton();
		
		//addExpensePage.waitForSuccessMessage();
		Assert.assertTrue(addExpensePage.isSuccessMsgDisplayed(), "Success Message Did not show");


	}


}
