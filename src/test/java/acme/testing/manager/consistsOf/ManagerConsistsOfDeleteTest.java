package acme.testing.manager.consistsOf;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerConsistsOfDeleteTest  extends AcmePlannerTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/consists-of/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow) {
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		final String url = this.getCurrentUrlComplete();
		final String[] parts = url.split("=");
		final String workplanId = parts[1];
		
		super.navigatePath("/manager/task/list-workplan?workPlanId="+workplanId);
		
		super.clickOnListingRecord(recordIndex2);
		
		super.clickOnButton("Delete Task from WorkPlan");
		
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
		
		super.signOut();
	}
	
	@Test
	public void deleteNegativeNotAuthorised() {

		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(0);
		
		String url = this.getCurrentUrlComplete();
		String[] parts = url.split("=");
		final String workplanId = parts[1];
		
		super.navigatePath("/manager/task/list-workplan?workPlanId="+workplanId);
		
		super.clickOnListingRecord(0);
		
		url = this.getCurrentUrlComplete();
		parts = url.split("\\?");
		final String query = parts[1];
		
		super.signOut();
		
		super.navigatePath("/manager/task/show-workplan?"+query);
		
		super.checkPanicExists();
	}
	
}
