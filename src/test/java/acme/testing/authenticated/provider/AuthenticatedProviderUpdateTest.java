package acme.testing.authenticated.provider;

import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedProviderUpdateTest extends AcmeWorkPlansTest{
	
	/* Test que comprueba que se produce error si intentamos actualizar nuestros datos de Provider vaciando los campos company y sector */
	
	@Test
	public void updateNegativeUnauthorised() {
		super.signIn("provider1", "provider1");
		super.clickOnMenu("Account", "Provider data");
		super.fillInputBoxIn("company", "");
		super.fillInputBoxIn("sector", "");
		super.clickOnSubmitButton("Update");
		super.checkErrorsExist();
	}
	
	
	/* Test simple que comprueba que como autenticado podemos actualizar nuestros datos de Provider correctamente*/
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
