package acme.testing.anonymous.shout;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousShoutCreateTest  extends AcmePlannerTest {
	
	/*
	 Este test crea un shout, se espera un resultado positivo.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String author, final String text, final String info) {
		
		
		super.clickOnMenu("Anonymous", "¡Shout!");

		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("text",text);
		super.fillInputBoxIn("info",info);
		
		super.clickOnSubmitButton("Shout!");

		super.clickOnMenu("Anonymous", "See shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);

		
	}
	/*
	 Este test intenta crear un shout añadiendo mal los datos en el csv como por ejemplo en info no utilizar un @,
	 dejar los campos author, text e info vacíos o pasarnos de 25 carácteres en el author. 
	 Se espera resultado negativo.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createNegative(final int recordIndex, final String author, final String text, final String info) {
		
		
		super.clickOnMenu("Anonymous", "¡Shout!");

		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("text",text);
		super.fillInputBoxIn("info",info);
		
		
		super.clickOnSubmitButton("Shout!");

		super.checkErrorsExist();

		
	}
	
}
