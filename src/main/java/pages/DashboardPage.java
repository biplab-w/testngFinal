package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardPage extends BasePage {
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(how=How.CSS, using="input[name='categorydata']") WebElement categoryField;
	@FindBy(how= How.CSS, using="input[value='Add category']") WebElement addCategoryButton;
	@FindBy(how=How.CSS,using="select[name='colour']") WebElement cDrop;
	@FindBy(how = How.LINK_TEXT, using="Add the category with this colour") WebElement confirmColorChange;
	@FindBy(how =How.CSS , using="div.controls>a>span") List<WebElement> categoryList;
	//Interactable Methods
	public String insertIntoCategoryField(String categoryName) {
		String categoryFormattedName = categoryName + generateRandomNumber();
		categoryField.sendKeys(categoryFormattedName);
		return categoryFormattedName;
	}
	
	public void clickonAddCategoryButton() {
		addCategoryButton.click();
	}
	
	public void selectFromColorDropDown(String color) {
		Select colorDropDown = new Select(cDrop);
		colorDropDown.selectByVisibleText(color);
	}
	
	public void clickOnConfirmColorChange() {
		if(confirmColorChange.isDisplayed()) {
			confirmColorChange.click();
		}
	}
	
	public void validateAddedCategoryIsDisplayed(String categoryName) {
		String lastInsertedCategoryValue = categoryList.get(categoryList.size()-1).getText();
		Assert.assertEquals(lastInsertedCategoryValue, categoryName);
	}
}
