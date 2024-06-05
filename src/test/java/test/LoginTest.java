package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String dashboardHeaderText = exlread.getCellData("DashboardInfo", "DashboardHeader", 2);
	String userAlertText = exlread.getCellData("LoginInfo", "alertUserValidationText", 2);
	String passwordAlertText = exlread.getCellData("LoginInfo", "alertPasswordValidationText", 2);

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();

		// LogPage lp= new LoginPage();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPssword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertEquals(dashboardPage.validateDashboardPageText(), dashboardHeaderText,
				"Dashboard page is not available!");
		BrowserFactory.tearDown();

	}

	@Test
	public void validateAlertPopup() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getUSerAlertMsg(),userAlertText, "user Alert msg doesn't match!!");

		loginPage.insertUserName(userName);
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getPasswordAlertMsg(), passwordAlertText,
				"Password Alert msg doesn't match!!");
	}

}
