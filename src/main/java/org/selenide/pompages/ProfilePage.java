package org.selenide.pompages;

import static com.codeborne.selenide.Selenide.$;

import org.selenide.entity.EmployeeDetails;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class ProfilePage {
	
	private static final SelenideElement PROFILE_HEAD = $(Selectors.byXpath("//img[@alt='profile picture']"));
	private static final SelenideElement ABOUT_MENU = $(Selectors.byXpath("//a[normalize-space()='About']"));
	private static final SelenideElement SUPPORT_MENU = $(Selectors.byXpath("//a[normalize-space()='Support']"));
	private static final SelenideElement LOGOUT = $(Selectors.byXpath("//a[normalize-space()='Logout']"));
	private static final SelenideElement ABOUT_PAGE = $(Selectors.byXpath("//a[normalize-space()='Logout']"));
	private static final SelenideElement ABOUT_PAGE_CLOSE = $(Selectors.byXpath("//button[normalize-space()='×']"));
	private static final SelenideElement SUPPORT_PAGE = $(Selectors.byXpath("//h6[normalize-space()='Getting Started with OrangeHRM']"));
	
	public ProfilePage openProfile() {
		PROFILE_HEAD.shouldBe(Condition.visible).click();
		return this;
	}
	
	public ProfilePage openAboutPage() {
		ABOUT_MENU.shouldBe(Condition.visible).click();
		return this;
	}
	
	public ProfilePage verifyAboutPage() {
		ABOUT_PAGE.shouldBe(Condition.visible).shouldHave(Condition.text("About"));
		ABOUT_PAGE_CLOSE.shouldBe(Condition.visible).click();
		return this;
	}
	
	public ProfilePage openSupportPage() {
		SUPPORT_MENU.shouldBe(Condition.visible).click();
		return this;
	}
	
	public ProfilePage verifySupportPage() {
		SUPPORT_PAGE.shouldBe(Condition.visible).shouldHave(Condition.text("Getting Started with OrangeHRM"));
		return this;
	}
	
	public ProfilePage userLogout() {
		LOGOUT.shouldBe(Condition.visible).click();
		return this;
	}

}
