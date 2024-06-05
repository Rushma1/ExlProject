package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String dashboardHeaderText = exlread.getCellData("DashboardInfo", "DashboardHeader", 2);
	String addCustomerHeaderText = exlread.getCellData("AddContactInfo", "AddContactValidationText", 2);
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String company = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String group = exlread.getCellData("AddContactInfo", "Group", 2);

	@Test
	public void userShouldBeAbleToCreateNewCustomer() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPssword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// Assert.assertEquals(dashboardPage.getDashboardValidationText(),
		// expectedAddCustomerHeaderText,"DashboardPage");
		dashboardPage.validationDashboardPage(dashboardHeaderText);
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		
		 Assert.assertEquals(addCustomerPage.getAddCustomerPage(),addCustomerHeaderText , "valide not found!! ");
		// expectedAddCustomerHeaderText, address);
		
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.selectgroup(group);

	}

}
