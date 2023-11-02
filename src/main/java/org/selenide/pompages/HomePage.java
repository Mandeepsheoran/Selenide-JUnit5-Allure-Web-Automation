package org.selenide.pompages;

import org.selenide.pompages.pagecomponents.LeftMenuComponentPage;

public class HomePage {
	
	private LeftMenuComponentPage leftmenucomponentpage;
	
	public HomePage() {
		this.leftmenucomponentpage = new LeftMenuComponentPage();
	}
	
	public LeftMenuComponentPage getLeftMenuComponent() {
		return leftmenucomponentpage;
	}

}
