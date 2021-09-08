package acme.testing.administrator.spamWord;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorSpamWordDeleteTest extends AcmeWorkPlansTest{

	/*
	 Este test borra una spamWord y posteriormente comprueba que no esta en el listado,
	 para ello mira que la palabra posterior ha ocupado su lugar, se espera un resultado
	 positivo
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamword/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void deletePositive(final int recordIndex, final String wordEn, final String wordEs, final String nextWordEn, final String nextWordEs) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Spam Words List");

		super.checkColumnHasValue(recordIndex, 0, wordEn);
		super.checkColumnHasValue(recordIndex, 1, wordEs);
		
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmitButton("Delete");

		super.clickOnMenu("Administrator", "Spam Words List");
		
		super.checkColumnHasValue(recordIndex, 0, nextWordEn);
		super.checkColumnHasValue(recordIndex, 1, nextWordEs);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("wordEn", nextWordEn);
		super.checkInputBoxHasValue("wordEs", nextWordEs);
		
		super.signOut();
	}

	/*
	 Este test intenta acceder al borrado sin loguearse como administrador,
	  se espera un resultado negativo.
	 */
	@Test
	public void deleteNegative() {
		super.navigatePath("/administrator/spamword/delete");
		super.checkPanicExists();
	}
}
