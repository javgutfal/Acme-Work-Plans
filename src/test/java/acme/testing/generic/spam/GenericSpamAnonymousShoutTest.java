package acme.testing.generic.spam;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class GenericSpamAnonymousShoutTest extends AcmeWorkPlansTest{

	/*
	 Este test crea un shout, se espera un resultado positivo.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/generic/spam/AnonymousShoutPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAnonymousCreateTestPositive(final int recordIndex, final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous","¡Shout!");
		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("text",text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");

		super.clickOnMenu("Anonymous", "See shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
	}
	
	/*
	 Este test intenta crear un shout con datos que violan las restricciones de spam, 
	 se espera resultado negativo.
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/generic/spam/AnonymousShoutNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAnonymousCreateTestNegative(final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous","¡Shout!");
		super.fillInputBoxIn("author",author);
		super.fillInputBoxIn("text",text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		super.checkErrorsExist();
	}
	
}
