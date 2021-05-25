package acme.testing.administrator.spamWord;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorSpamWordCreateTest extends AcmePlannerTest{

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------
	/*
	 Este test crea varias spamWords y comprueba que se encuentran en el listado,
	 se espera un resultado positivo
	 */
		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/spamword/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void createPositive(final int recordIndex, final String wordEn, final String wordEs) {
			super.signIn("administrator", "administrator");

			super.clickOnMenu("Administrator", "Create spam word");

			super.fillInputBoxIn("wordEn", wordEn);
			super.fillInputBoxIn("wordEs", wordEs);
			
			super.clickOnSubmitButton("Create");

			super.clickOnMenu("Administrator", "Spam Words List");
			
			super.checkColumnHasValue(recordIndex, 0, wordEn);
			super.checkColumnHasValue(recordIndex, 1, wordEs);

			super.clickOnListingRecord(recordIndex);

			super.checkInputBoxHasValue("wordEn", wordEn);
			super.checkInputBoxHasValue("wordEs", wordEs);
			
			super.signOut();
		}
		
		/*
		 Este test intenta crear spamWords pero sobrepasando las limitaciones
		 de los validadores, se espera un resultado negativo
		 */
		@ParameterizedTest
		@CsvFileSource(resources = "/administrator/spamword/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void createNegative(final int recordIndex, final String wordEn, final String wordEs) {
			super.signIn("administrator", "administrator");

			super.clickOnMenu("Administrator", "Create spam word");

			super.fillInputBoxIn("wordEn", wordEn);
			super.fillInputBoxIn("wordEs", wordEs);
			
			super.clickOnSubmitButton("Create");

			super.checkErrorsExist();

			super.signOut();
		}

		// Ancillary methods ------------------------------------------------------
}
