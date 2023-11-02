package org.selenide.testdata;

import org.selenide.entity.LoginDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class LoginDetailsTestData {
	
private static final PodamFactory factory = new PodamFactoryImpl();
	
	public static LoginDetails getLoginDetails() {
		return factory.manufacturePojo(LoginDetails.class);
	}

}
