package acme.testing.administrator.spamWord;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorSpamWordListTest extends AcmePlannerTest{
	
	/*
	 Este test comprueba el listado de spamWord, se espera un resultado positivo
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamword/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String wordEn) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Spam Words List");

		super.checkColumnHasValue(recordIndex, 0, wordEn);
		
		
		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("wordEn", wordEn);

		
		super.signOut();
	}
	/*
	 Este test intenta acceder al listado sin loguearse como administrador,
	  se espera un resultado negativo.
	 */
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/spamword/list");
		super.checkErrorsExist();
	}
}
