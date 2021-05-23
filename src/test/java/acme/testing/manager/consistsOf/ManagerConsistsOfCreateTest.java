package acme.testing.manager.consistsOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerConsistsOfCreateTest extends AcmePlannerTest{
	
	@Override
	@BeforeEach
	public void beforeEach() {
		super.beforeEach();
		
		this.navigateHome();
		this.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");
		super.checkAlertExists(true);		
		this.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/manager/consists-of/create-positive-public.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositivePublicWorkplan(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow,final int recordIndex3) {
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		super.clickOnButton("Add tasks");
		
		super.clickOnListingRecord(recordIndex2);
		
		super.clickOnButton("Add Task");
		
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		super.clickOnButton("List of tasks");
		
		super.checkColumnHasValue(recordIndex3, 0, title);
		super.checkColumnHasValue(recordIndex3, 1, initialTime);
		super.checkColumnHasValue(recordIndex3, 2, finalTime);
		super.checkColumnHasValue(recordIndex3, 3, workload);
		super.checkColumnHasValue(recordIndex3, 4, link);
		super.checkColumnHasValue(recordIndex3, 5, description);
		super.checkColumnHasValue(recordIndex3, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex3);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/consists-of/create-positive-private.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositivePrivateWorkplan(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow,final int recordIndex3) {
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		super.clickOnButton("Add tasks");
		
		super.clickOnListingRecord(recordIndex2);
		
		super.clickOnButton("Add Task");
		
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		super.clickOnButton("List of tasks");
		
		super.checkColumnHasValue(recordIndex3, 0, title);
		super.checkColumnHasValue(recordIndex3, 1, initialTime);
		super.checkColumnHasValue(recordIndex3, 2, finalTime);
		super.checkColumnHasValue(recordIndex3, 3, workload);
		super.checkColumnHasValue(recordIndex3, 4, link);
		super.checkColumnHasValue(recordIndex3, 5, description);
		super.checkColumnHasValue(recordIndex3, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex3);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/consists-of/create-positive-public.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositiveAccessWithURL(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow,final int recordIndex3) {
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		String url = this.getCurrentUrlComplete();
		String[] parts = url.split("=");
		String workplanId = parts[1];
		
		super.navigatePath("/manager/task/list-not-workplan?workPlanId="+workplanId);
		
		super.clickOnListingRecord(recordIndex2);
		
		super.clickOnButton("Add Task");
		
		super.clickOnMenu("Manager", "View workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		url = this.getCurrentUrlComplete();
		parts = url.split("=");
		workplanId = parts[1];
		
		super.navigatePath("/manager/task/list-workplan?workPlanId="+workplanId);
		
		super.checkColumnHasValue(recordIndex3, 0, title);
		super.checkColumnHasValue(recordIndex3, 1, initialTime);
		super.checkColumnHasValue(recordIndex3, 2, finalTime);
		super.checkColumnHasValue(recordIndex3, 3, workload);
		super.checkColumnHasValue(recordIndex3, 4, link);
		super.checkColumnHasValue(recordIndex3, 5, description);
		super.checkColumnHasValue(recordIndex3, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex3);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
	}
	
}
