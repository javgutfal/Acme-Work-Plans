package acme.testing.manager.consistsOf;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerConsistsOfListTest extends AcmePlannerTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/consists-of/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow) {
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		final String url = this.getCurrentUrlComplete();
		final String[] parts = url.split("=");
		final String workplanId = parts[1];
		
		super.navigatePath("/manager/task/list-workplan?workPlanId="+workplanId);
		
		super.checkColumnHasValue(recordIndex2, 0, title);
		super.checkColumnHasValue(recordIndex2, 1, initialTime);
		super.checkColumnHasValue(recordIndex2, 2, finalTime);
		super.checkColumnHasValue(recordIndex2, 3, workload);
		super.checkColumnHasValue(recordIndex2, 4, link);
		super.checkColumnHasValue(recordIndex2, 5, description);
		super.checkColumnHasValue(recordIndex2, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex2);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
		
		//super.checkButtonExists("Delete Task from Workplan");
	}
	
}
