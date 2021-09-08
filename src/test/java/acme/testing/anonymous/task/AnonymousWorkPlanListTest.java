package acme.testing.anonymous.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AnonymousWorkPlanListTest extends AcmeWorkPlansTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/work-plan/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex, final String manager, final String initialTime, final String finalTime, final String workload, final String published) {
		super.clickOnMenu("Anonymous", "See workplans");
		
		super.checkColumnHasValue(recordIndex, 0, manager);
		super.checkColumnHasValue(recordIndex, 1, initialTime);
		super.checkColumnHasValue(recordIndex, 2, finalTime);
		super.checkColumnHasValue(recordIndex, 3, workload);
		super.checkColumnHasValue(recordIndex, 4, published);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("manager", manager);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("published", published);
	}

}
