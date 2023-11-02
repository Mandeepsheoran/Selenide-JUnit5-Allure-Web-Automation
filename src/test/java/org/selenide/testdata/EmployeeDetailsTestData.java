package org.selenide.testdata;

import org.selenide.entity.EmployeeDetails;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class EmployeeDetailsTestData {
	
	private static final PodamFactory factory = new PodamFactoryImpl();
	
	public static EmployeeDetails getRandomEmployeeDetails() {
		return factory.manufacturePojo(EmployeeDetails.class);
	}
	
	

}
