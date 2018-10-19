package utilities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestException;

import stepDefs.Hooks;


public class BasePage {

	private final WebDriver webDriver;

	public BasePage(final WebDriver driver) {
		this.webDriver = Hooks.driver;
	}

	public void enterIntoInputField(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.TAB);
		} catch (NoSuchElementException nse) {
			throw new TestException("WebElement \"" + element + "\" not found on the page");
		}
	}

	public String getText(final WebElement element) {
		try {
			return element.getText();
		} catch (NoSuchElementException nse) {
			throw new TestException("WebElement \"" + element + "\" not found on the page");
		}
	}

	public void selectFromDropDown(final WebElement element, final String optionToSelect) throws TestException {
		boolean flag = false;
		final List<WebElement> optionList = element.findElements(By.tagName("option"));
		try {
			for (final WebElement option : optionList)
				if (option.getText().toLowerCase().contains(optionToSelect.toLowerCase())) {
					option.click();
					flag = true;
					break;
				}
			if (!flag)
				throw new TestException("There is no such option in the drop down!");
		} catch (Exception e) {
			throw new TestException("Dropdown item :\"" + optionToSelect + "\" is not found in the Dropdown ");
		}
	}

	public void tickCheckbox(final WebElement element) {
		try {
			boolean checkstatus;
			checkstatus = element.isSelected();
			if (checkstatus) {
				System.out.println("Checkbox is already checked");
			} else
				element.click();
		} catch (NoSuchElementException nse) {
			throw new TestException("WebElement \"" + element + "\" not found on the page");
		}
	}

	public void scrollToElement(final WebElement element) {
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element);
		actions.perform();
	}
}
