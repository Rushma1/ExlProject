package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy(how=How.XPATH,using="html/body/div[1]/section/div/div[2]/div/div[1]/div/div/header/div/strong") WebElement addCustomerHeaderElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[1]/div/input") WebElement fullNameElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[2]/div/select") WebElement companyDropdownElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[2]/div/select") WebElement emailElement;		
	@FindBy(how=How.XPATH,using="//*[@id=\"phone\"]") WebElement phoneElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[5]/div/input") WebElement addressElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[6]/div/input") WebElement cityElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"port\"]") WebElement zipElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"general_company\"]/div[8]/div[1]/select") WebElement countryDropdownElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"customer_group\"]") WebElement groupDropdownElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"save_btn\"]") WebElement saveButtonElement;
	
	
	public String getAddCustomerPage() {
		String actualNewCustomerHeaderText =  addCustomerHeaderElement.getText();
		return  actualNewCustomerHeaderText;
	}
		
	//public void validateAddCustomerPage(String addCustomerHeaderText) {
	//Assert.assertEquals(addCustomerHeaderElement.getText(),addCustomerHeaderText,"Dashboard page not found!!");

	

	public void insertFullName(String fullName) {
		String insertedName= fullName + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
}
	public void selectCompany(String visibleText) {
		selectFromDropdown(companyDropdownElement,visibleText);
		
	
	}
	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(9999) + email);
	}
	public void insertPhone(String phone) {
		phoneElement.sendKeys(phone + generateRandomNum(9999));
	}
	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}
	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}
	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(countryDropdownElement, country);
	}
	public void selectgroup(String group) {
		selectFromDropdown(groupDropdownElement,group);
	
	}
	}
