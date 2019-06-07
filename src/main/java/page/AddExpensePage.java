package page;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddExpensePage extends BasePage {
	// global
		WebDriver driver;
	// Constructor 
		public AddExpensePage(WebDriver driver) {
			this.driver = driver;
		}

		// elements
		@FindBy(xpath = "//h5[text() ='Add Expense']")
		WebElement AddExpensePanelHeading;
		@FindBy(xpath = "//select[@id='account']")
		WebElement ExpenseAccount;
		@FindBy(how = How.ID, using = "date")
		WebElement DateField;
		@FindBy(how = How.ID, using = "description")
		WebElement Description;
		@FindBy(how = How.ID, using = "amount")
		WebElement Amount;
		@FindBy(how = How.ID, using = "submit")
		WebElement SubmitButton;
		@FindBy(how = How.XPATH, using = "//button[@data-dismiss='alert']")
		WebElement ShowSuccessMessage;

		public void WaitForPage() {
			waitForElement(AddExpensePanelHeading, driver);
		}
			
		

		public void selectFromDropDownForExpense(String string) {
			Select AccountDropDown = new Select(ExpenseAccount);
			AccountDropDown.selectByVisibleText(string);
		}

		public void clearTheDateAndInput(String string) {
			DateField.clear();
			DateField.sendKeys(string);
			DateField.sendKeys(Keys.TAB);
		}

		public void clickAway() {
			AddExpensePanelHeading.click();
		}

		public void inputExpenseDescriptionAndAmount(String expenseDescription, String expenseAmount) {
			Description.sendKeys(expenseDescription);
			Amount.sendKeys(expenseAmount);
		}

		public void SubmitButton() {
			SubmitButton.click();
		}

		public boolean isSuccessMsgDisplayed() {
			try {
				return ShowSuccessMessage.isDisplayed();
			} catch (NoSuchElementException e) {
				return false;
			} catch (TimeoutException e) {
				return false;
			}
		}
}
