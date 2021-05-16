package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedManagerCreateTest extends AcmePlannerTest{

	
	@Test
	public void createNegativeUnauthorised() {

		super.navigatePath("authenticated/manager/create");

		super.sleep(10, true);
		super.checkErrorsExist();
	}
	
	@Test
	public void createPositive() {
		super.signIn("authenticated1", "authenticated1");

		super.clickOnMenu("Account", "Become a manager");
		
		super.clickOnSubmitButton("Register");

		super.checkLinkExists("Manager");

		super.signOut();
	}
	
}
