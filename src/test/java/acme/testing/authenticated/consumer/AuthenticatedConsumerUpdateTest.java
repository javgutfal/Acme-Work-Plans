package acme.testing.authenticated.consumer;

import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedConsumerUpdateTest extends AcmeWorkPlansTest{
	
	/*
	 Este test intenta actualizar los datos de un consumer dejando los parámetros vacios,
	 se espera un resultado negativo.
	 */
	@Test
	public void updateNegativeUnauthorised() {
		super.signIn("consumer1", "consumer1");
		super.clickOnMenu("Account", "Consumer data");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	/*
	 Este test actualiza los datos de un consumer, se espera un resultado positivo.
	 */
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
