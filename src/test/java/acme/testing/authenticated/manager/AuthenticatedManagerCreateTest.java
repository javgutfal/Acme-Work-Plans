package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedManagerCreateTest extends AcmeWorkPlansTest{

	//Intento de acceder al formulario para convertirse en mánager sin estar autenticado
	//Se comprueba que se genera una visa de error
	
	@Test
	public void createNegativeUnauthorised() {

		super.navigatePath("/authenticated/manager/create");

		super.checkPanicExists();
	}
	
	//Caso exitoso de intento de convertirse en mánager siendo usuario autenticado
	//Se comprueba que se tiene acceso a las opciones de mánager en el menú
	
	@Test
	public void createPositive() {
		super.signIn("authenticated1", "authenticated1");

		super.clickOnMenu("Account", "Become a manager");
		
		super.clickOnSubmitButton("Register");

		super.checkLinkExists("Manager");

		super.signOut();
	}
	
}
