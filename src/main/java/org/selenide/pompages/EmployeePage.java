package org.selenide.pompages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

import org.selenide.entity.EmployeeDetails;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;

public class EmployeePage {

	private static final SelenideElement ADD_EMPLOYEE = $(Selectors.byTagAndText("a", "Add Employee"));
	private static final SelenideElement FIRST_NAME = $(Selectors.byName("firstName"));
	private static final SelenideElement LAST_NAME = $(Selectors.byName("lastName"));
	private static final SelenideElement MIDDLE_NAME = $(Selectors.byName("middleName"));
	private static final SelenideElement IMAGE = $(Selectors.byXpath("//input[@type='file']"));
	private static final SelenideElement SAVE_BUTTON = $(Selectors.byText("Save"));
	private static final SelenideElement SUCCESS_MSG = $(Selectors.byText("Success"));
	private static final SelenideElement EMPLOYEE_LIST = $(Selectors.byTagAndText("a", "Employee List"));
	private static final ElementsCollection EMPLOYEE_STATUS_DROPDOWN = $$(Selectors.byClassName("oxd-select-text-input")).first(0);
	private static final SelenideElement SUBMIT_BUTTON = $(Selectors.byXpath("//button[@type='submit']"));
	private static final SelenideElement EDIT_BUTTON = $(Selectors.byXpath("//div[@role='table']//div[1]//div[1]//div[9]//div[1]//button[2]//i[1]"));
	private static final SelenideElement DELETE_BUTTON = $(Selectors.byXpath("//div[@role='table']//div[1]//div[1]//div[9]//div[1]//button[1]//i[1]"));
	private static final SelenideElement DELETE_CONFIMATION = $(Selectors.byXpath("//button[normalize-space()='Yes, Delete']"));
	private static final SelenideElement NO_RECORD = $(Selectors.byText("No Records Found"));
	
	public EmployeePage addNewEmployee(EmployeeDetails employee) {
		ADD_EMPLOYEE.shouldBe(Condition.visible).click();
		FIRST_NAME.shouldBe(Condition.visible).setValue(employee.getFirstName());
		LAST_NAME.shouldBe(Condition.visible).setValue(employee.getLastName());
		MIDDLE_NAME.shouldBe(Condition.visible).setValue(employee.getMiddleName());
	//	IMAGE.shouldBe(Condition.visible).uploadFromClasspath("Capture.PNG");		
		SAVE_BUTTON.shouldBe(Condition.enabled).click();
		return this;
	}
	
	public void checkEmployeeCreation() {
		SUCCESS_MSG.should(Condition.visible).shouldHave(Condition.text("Success"));
	}
	
	public EmployeePage searchEmployee() {
		//EMPLOYEE_LIST.shouldBe(Condition.visible).click();
		SUBMIT_BUTTON.shouldBe(Condition.enabled).click();
		return this;
	}
	
	public void verifySearchOperation() {
		SUBMIT_BUTTON.should(Condition.visible);
	}
	
	public EmployeePage editEmployee() {
		executeJavaScript("window.scrollBy(0, 250);");
		Configuration.timeout=5000;
		EDIT_BUTTON.click();
		Configuration.timeout=5000;
		return this;
	}
	
	public EmployeePage deleteEmployee() {
		executeJavaScript("window.scrollBy(0, 250);");
		DELETE_BUTTON.click();
		Configuration.timeout=5000;
		DELETE_CONFIMATION.shouldBe(Condition.visible).click();
		Configuration.timeout=5000;
		return this;
	}
	
	public EmployeePage searchAdminUser() {
		SUBMIT_BUTTON.shouldBe(Condition.enabled).click();
		Configuration.timeout=5000;
		return this;
	}
	
	public EmployeePage getRecruitment() {
		SUBMIT_BUTTON.shouldBe(Condition.enabled).click();
		Configuration.timeout=5000;
		NO_RECORD.shouldBe(Condition.visible).shouldHave(Condition.text("No Records Found"));
		return this;
	}
	
}
