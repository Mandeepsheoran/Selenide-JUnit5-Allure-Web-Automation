package org.selenide.pompages.pagecomponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

public class LeftMenuComponentPage {
	
	public void selectLeftMenuOptions(String menuName) {
		Selenide.$(Selectors.byText(menuName)).should(Condition.enabled).click();
	}

}
