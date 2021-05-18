package acme.testing.administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorSpamWordUpdateTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamword/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updatePositive(final int recordIndex, final String prevWordEn,final String prevWordEs,final String wordEn, final String wordEs) {		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam Words List");		
		
		super.checkColumnHasValue(recordIndex, 0, prevWordEn);
		super.checkColumnHasValue(recordIndex, 1, prevWordEs);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("wordEn", wordEn);
		super.fillInputBoxIn("wordEs", wordEs);
		
		
		super.clickOnSubmitButton("Update");
		
		super.checkColumnHasValue(recordIndex, 0, wordEn);
		super.checkColumnHasValue(recordIndex, 1, wordEs);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("wordEn", wordEn);
		super.checkInputBoxHasValue("wordEs", wordEs);
		
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/spamword/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateNegative(final int recordIndex, final String prevWordEn,final String prevWordEs,final String wordEn, final String wordEs) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Spam Words List");		
		
		super.checkColumnHasValue(recordIndex, 0, prevWordEn);
		super.checkColumnHasValue(recordIndex, 1, prevWordEs);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("wordEn", wordEn);
		super.fillInputBoxIn("wordEs", wordEs);
		
		super.clickOnSubmitButton("Update");

		super.checkErrorsExist();

		super.signOut();
	}
}
