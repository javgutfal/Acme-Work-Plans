package acme.testing.authenticated.provider;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedProviderUpdateTest extends AcmePlannerTest{
	
	@Test
	public void updateNegativeUnauthorised() {
		super.signIn("provider1", "provider1");
		super.clickOnMenu("Account", "Provider data");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	@Test
	public void updatePositive() {
		super.signIn("provider1", "provider1");

		super.clickOnMenu("Account", "Provider data");
		
		super.fillInputBoxIn("company", "Company2");
		super.fillInputBoxIn("sector", "Sector2");
		
		super.clickOnSubmitButton("Update");

		super.checkLinkExists("Provider");

		super.signOut();
	}

}
