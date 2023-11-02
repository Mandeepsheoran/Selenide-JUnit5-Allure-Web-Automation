package org.selenide.basetest;

import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

@ExtendWith(TextReportExtension.class)
public class BaseTest {

	@BeforeAll
	static void setupAllureReports() {
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
	}

	@BeforeEach
	public void setUp() {
		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

}
