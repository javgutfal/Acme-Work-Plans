package acme.testing.administrator.percent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorPercentListTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String code, final String data) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Percents list");

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, data);
		
		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("data", data);
		
		super.signOut();
	}
	
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/variable/percent/list");
		super.checkErrorsExist();
	}
}
