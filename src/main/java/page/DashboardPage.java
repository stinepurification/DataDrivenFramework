package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage{
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// element library or repository
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit")
	WebElement AddDepositButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Expense']")
	WebElement AddExpenseButton;

	// calling a wait method. creates a explicit wait
	public void WaitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void clickOnAddDepositButton() {
		AddDepositButton.click();
	}

	public void clickOnAddExpenseButton() {
		AddExpenseButton.click();
	}

}
