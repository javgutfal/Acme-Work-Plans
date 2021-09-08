package acme.testing.authenticated.consumer;

import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedConsumerCreateTest extends AcmeWorkPlansTest{
	
	/*
	 Este test intenta crear un consumer sin añadir company ni sector, 
	 se espera resultado negativo.
	 */
	@Test
	public void createNegativeUnauthorised() {
		super.signIn("authenticated1", "authenticated1");
		super.clickOnMenu("Account", "Become a consumer");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Register");
		super.checkErrorsExist();
	}
	/*
	 Este test crea un consumer, se espera un resultado positivo.
	 */
	@Test
	public void createPositive() {
		super.signIn("authenticated1", "authenticated1");

		super.clickOnMenu("Account", "Become a consumer");
		
		super.fillInputBoxIn("company", "Almendralejo S.L");
		super.fillInputBoxIn("sector", "Industrial Transport");
		
		super.clickOnSubmitButton("Register");

		super.checkLinkExists("Consumer");

		super.signOut();
	}

}
