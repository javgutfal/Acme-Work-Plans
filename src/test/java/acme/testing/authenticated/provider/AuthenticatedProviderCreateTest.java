package acme.testing.authenticated.provider;

import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedProviderCreateTest extends AcmeWorkPlansTest{
	
	
	/* Test que comprueba que se produce error si intentamos convertirnos en Provider sin rellenar los campos company y sector */
	@Test
	public void createNegativeUnauthorised() {
		super.signIn("authenticated1", "authenticated1");
		super.clickOnMenu("Account", "Become a provider");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Register");
		super.checkErrorsExist();
	}
	
	
	/* Test simple que comprueba que como autenticado podemos convertirnos en Provider correctamente*/
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
