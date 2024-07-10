package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how=How.XPATH,using="/html/body/div[1]/section/div/div[2]/div/div/header/div/string") WebElement dashboardHeaderElement;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span") WebElement customerButtonElement;
	@FindBy(how=How.XPATH,using="//span[text()='Add Customer']") WebElement addCustomerButtonElement;
	
	
	
	
	
	public void validationDashboardPage(String dashboarHeaderText) {
		
		//Assert.assertEquals(dashboardHeaderElement.getText(),dashboarHeaderText,"Dashboard page not found.");
		
	}
	public String validateDashboardPageText() {
		String actualHederText = dashboardHeaderElement.getText();
		return actualHederText;
	}
	public void clickOnCustomerButton() {
		customerButtonElement.click();
	}
	public void clickOnAddCustomerButton() {
		addCustomerButtonElement.click();
	}
}
