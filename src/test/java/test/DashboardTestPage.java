package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashboardPage;
import util.BrowserFactory;

public class DashboardTestPage {
	WebDriver driver;
	DashboardPage dashboardPage;
	String categoryName;
	
	@BeforeMethod
	public void initalizeBrowser() {
		driver = BrowserFactory.init();
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
	}

	//	Test 1: Validate a user is able to add a category 
	//	and once the category is added it should display.
	@Test
	public void addCategoryAndValidate() {
		categoryName = dashboardPage.insertIntoCategoryField("Furniture");
		dashboardPage.selectFromColorDropDown("Burnt Orange");
		dashboardPage.clickonAddCategoryButton();
		dashboardPage.clickOnConfirmColorChange();
		dashboardPage.validateAddedCategoryIsDisplayed(categoryName);
	}
	
	
	
	//	Test 2: Validate a user is not able to add a duplicated category.
	
	@Test
	public void userShouldNotBeAbleToAddDuplicateCategory() {
		String constantCategory = "MagentusTheCreamy";
		dashboardPage.insertIntoCategoryFieldConstantValue(constantCategory);
		dashboardPage.clickonAddCategoryButton();
		dashboardPage.validateIfCategoryAlreadyExists(constantCategory);
		
		
	}
	
	// Test 3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	@Test
	public void validateMonthDropDown() {
		dashboardPage.validateMonths();
	}
	
	
	
	
}
