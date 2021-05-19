package acme.testing.authenticated.provider;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedProviderCreateTest extends AcmePlannerTest{
	
	@Test
	public void createNegativeUnauthorised() {
		super.signIn("authenticated1", "authenticated1");
		super.clickOnMenu("Account", "Become a provider");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Register");
		super.checkErrorsExist();
	}
	
	@Test
	public void createPositive() {
		super.signIn("authenticated1", "authenticated1");

		super.clickOnMenu("Account", "Become a provider");
		
		super.fillInputBoxIn("company", "Almendralejo S.L");
		super.fillInputBoxIn("sector", "Industrial Transport");
		
		super.clickOnSubmitButton("Register");

		super.checkLinkExists("Provider");

		super.signOut();
	}

}
