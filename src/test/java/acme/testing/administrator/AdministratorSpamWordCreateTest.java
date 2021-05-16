package acme.testing.administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorSpamWordCreateTest extends AcmePlannerTest{

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

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
		
		/*@ParameterizedTest
		@CsvFileSource(resources = "/employer/job/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(20)
		public void createNegative(final int recordIndex, final String reference, final String title, final String deadline, final String salary, final String score, final String moreInfo, final String description) {
			super.signIn("administrator", "administrator");

			super.clickOnMenu("Employer", "Create a job");

			super.fillInputBoxIn("reference", reference);
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("deadline", deadline);
			super.fillInputBoxIn("salary", salary);
			super.fillInputBoxIn("score", score);
			super.fillInputBoxIn("moreInfo", moreInfo);
			super.fillInputBoxIn("description", description);
			super.clickOnSubmitButton("Create");

			super.checkErrorsExist();

			super.signOut();
		}*/

		// Ancillary methods ------------------------------------------------------
}
