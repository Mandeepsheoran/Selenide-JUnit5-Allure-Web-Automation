package org.selenide.webtest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.OutputType;
import org.selenide.basetest.BaseTest;
import org.selenide.entity.EmployeeDetails;
import org.selenide.entity.LoginDetails;
import org.selenide.pompages.EmployeePage;
import org.selenide.pompages.HomePage;
import org.selenide.pompages.LoginPage;
import org.selenide.pompages.ProfilePage;
import org.selenide.testdata.EmployeeDetailsTestData;
import org.selenide.testdata.LoginDetailsTestData;

import java.util.Base64;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Selenide.*;

@TestMethodOrder(OrderAnnotation.class)
public class DemoWebTest extends BaseTest {
	EmployeeDetails employee = EmployeeDetailsTestData.getRandomEmployeeDetails();
	LoginDetails logindata = LoginDetailsTestData.getLoginDetails();
	
	ProfilePage profilepage = new ProfilePage();

	@Test
	@Order(1)
	public void addEmployee() {

		new LoginPage().loginApplication(logindata);
		new HomePage().getLeftMenuComponent().selectLeftMenuOptions("PIM");
		new EmployeePage().addNewEmployee(employee).checkEmployeeCreation();
	}

	@Test
	@Order(2)
	public void searchEmployee() {
		new HomePage().getLeftMenuComponent().selectLeftMenuOptions("PIM");
		new EmployeePage().searchEmployee().editEmployee();
		
		String editPageScreenshot = Selenide.screenshot("edit_view");
		String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
		byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
	}
	
	@Test
	@Order(3)
	public void deleteEmployeeRecord() {
		new HomePage().getLeftMenuComponent().selectLeftMenuOptions("PIM");
		new EmployeePage().searchEmployee().deleteEmployee();
	}
	

	@Test
	@Order(4)
	public void searchAdminUser() {
		new HomePage().getLeftMenuComponent().selectLeftMenuOptions("Admin");
		new EmployeePage().searchAdminUser();
	}
	
	@Test
	@Order(5)
	public void getRecuritmentList() {
		new HomePage().getLeftMenuComponent().selectLeftMenuOptions("Recruitment");
		new EmployeePage().getRecruitment();
	}
	
	@Test
	@Order(6)
	public void checkAboutPage() {
		profilepage.openProfile().openAboutPage().verifyAboutPage();
	}
	
	@Test
	@Order(7)
	public void verifySupportPage() {
		profilepage.openProfile().openSupportPage().verifySupportPage();
	}
	
	@Test
	@Order(8)
	public void logoutTest() {
		profilepage.openProfile().userLogout();
	}
}
