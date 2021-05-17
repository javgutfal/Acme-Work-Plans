package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedManagerUpdateTest extends AcmePlannerTest{

	@Test
	public void createPositive() {
		super.signIn("manager", "asdf1234");

		super.clickOnMenu("Account", "Manager data");
		
		super.clickOnSubmitButton("Update");

		super.checkLinkExists("Manager");

		super.signOut();
	}
	
	@Test
	public void createNegativeUnauthorised() {
		
		super.navigatePath("/authenticated/manager/update");
		super.checkErrorsExist();
	}
	
}
