/*
 * SignUpTest.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class SignUpTest extends AcmePlannerTest{
	
	//Caso exitoso de intento de registro en el sistema como usaurio autenticado.
	//Se comprueba que se tiene acceso a las opciones de cuenta en el menú.
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSignUp(final String username, final String password, final String name, final String surname, final String email) {
		this.signUp(username, password, name, surname, email);
		this.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		this.signOut();
	}
	
	//Caso fallido de intento de registro en el sistema como usuario autenticado con un nombre
	//de usuario ya existente.
	//Se comprueba que se genera una vista de pánico después de enviar el formulario
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative-username-already-taken.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUpUsernameTaken(final String username, final String password, final String name, final String surname, final String email) {
		this.signUpFail(username, password, name, surname, email);
	}
	
	//Caso fallido de intento de registro en el sistema como usuario autenticado con una
	//contraseña demasiado corta.
	//Se comprueba que se genera una vista de pánico después de enviar el formulario
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative-password-short.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUpPasswordShort(final String username, final String password, final String name, final String surname, final String email) {
		this.signUpFail(username, password, name, surname, email);
	}
	
}
