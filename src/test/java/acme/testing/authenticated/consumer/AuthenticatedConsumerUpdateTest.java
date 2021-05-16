package acme.testing.authenticated.consumer;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedConsumerUpdateTest extends AcmePlannerTest{
	
	@Test
	public void updateNegativeUnauthorised() {
		super.signIn("consumer1", "consumer1");
		super.clickOnMenu("Account", "Consumer data");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@Test
	public void updatePositive() {
		super.signIn("consumer1", "consumer1");

		super.clickOnMenu("Account", "Consumer data");
		
		super.fillInputBoxIn("company", "Company2");
		super.fillInputBoxIn("sector", "Sector2");
		
		super.clickOnSubmitButton("Update");

		super.checkLinkExists("Consumer");

		super.signOut();
	}

}
