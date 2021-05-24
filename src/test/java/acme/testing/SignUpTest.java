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

	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSignUp(final String username, final String password, final String name, final String surname, final String email) {
		this.signUp(username, password, name, surname, email);
		this.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		this.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative-username-already-taken.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUpUsernameTaken(final String username, final String password, final String name, final String surname, final String email, final String phone) {
		this.signUpFail(username, password, name, surname, email);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative-email-already-taken.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUpEmailTaken(final String username, final String password, final String name, final String surname, final String email, final String phone) {
		this.signUpFail(username, password, name, surname, email);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative-password-short.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeSignUpPasswordShort(final String username, final String password, final String name, final String surname, final String email, final String phone) {
		this.signUpFail(username, password, name, surname, email);
	}
	
}
