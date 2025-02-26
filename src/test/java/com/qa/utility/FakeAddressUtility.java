package com.qa.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPojo;

public class FakeAddressUtility {

	public static AddressPojo getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		
		AddressPojo addressPojo = 
				new AddressPojo(faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), 
						faker.address().city(),faker.numerify("#####"), faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),
						"sample address test", "Office address", faker.address().state());

		return addressPojo;
	}

	public static void main(String[] args) {
		getFakeAddress();

	}
}
