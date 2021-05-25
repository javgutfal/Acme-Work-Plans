package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AuthenticatedManagerUpdateTest extends AcmePlannerTest{

	//Caso exitoso de intento de actualizar privilegios de mánager siendo usuario autenticado
	//Se comprueba que se tiene acceso a las opciones de mánager en el menú
	
	@Test
	public void createPositive() {
		super.signIn("manager", "asdf1234");

		super.clickOnMenu("Account", "Manager data");
		
		super.clickOnSubmitButton("Update");

		super.checkLinkExists("Manager");

		super.signOut();
	}
	
	//Intento de acceder al formulario para actualizar privilegios de mánager sin estar autenticado
	//Se comprueba que se genera una visa de error
	
	@Test
	public void createNegativeUnauthorised() {
		
		super.navigatePath("/authenticated/manager/update");
		super.checkPanicExists();
	}
	
}
