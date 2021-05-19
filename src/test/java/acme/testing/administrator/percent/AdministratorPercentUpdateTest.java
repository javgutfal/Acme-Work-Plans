package acme.testing.administrator.percent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorPercentUpdateTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updatePositive(final int recordIndex, final String prevValue,final String value) {		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Percents list");		
		
		super.checkColumnHasValue(recordIndex, 1, prevValue);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("data", value);

		
		super.clickOnSubmitButton("Update");
		
		super.checkColumnHasValue(recordIndex, 1, value);

		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("data", value);

		
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateNegative(final int recordIndex, final String prevValue,final String value) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Percents list");		
		
		super.checkColumnHasValue(recordIndex, 1, prevValue);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("data", value);
		
		super.clickOnSubmitButton("Update");

		super.checkErrorsExist();
		
		super.signOut();
	}
}
