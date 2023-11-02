package org.selenide.pompages;

import com.codeborne.selenide.Selectors;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import org.selenide.entity.LoginDetails;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
	
	private static SelenideElement USERNAME = $(Selectors.byName("username"));
	private static SelenideElement PASSWORD = $(Selectors.byName("password"));
	private static SelenideElement LOGIN_BUTTON = $(Selectors.byCssSelector("[type='submit']"));
	
	public HomePage loginApplication(LoginDetails logindata) {
		USERNAME.shouldBe(Condition.visible).setValue(logindata.getUsername());
		PASSWORD.shouldBe(Condition.visible).setValue(logindata.getPassword());		
	//	LOGIN_BUTTON.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
		LOGIN_BUTTON.shouldBe(Condition.enabled).click(ClickOptions.usingJavaScript());
		return new HomePage();
	}

}
