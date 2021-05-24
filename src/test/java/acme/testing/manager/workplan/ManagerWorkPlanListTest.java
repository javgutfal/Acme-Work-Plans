package acme.testing.manager.workplan;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerWorkPlanListTest extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex, final String initialTime, final String finalTime, final String workload, final String publicWorkPlan, final String published, final String publicWorkPlanShow) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");
		
		super.checkColumnHasValue(recordIndex, 0, initialTime);
		super.checkColumnHasValue(recordIndex, 1, finalTime);
		super.checkColumnHasValue(recordIndex, 2, workload);
		super.checkColumnHasValue(recordIndex, 3, publicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, published);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("publicWorkPlan", publicWorkPlanShow);
		
		super.checkButtonExists("Update Workplan");
		super.checkButtonExists("Delete Workplan");
		
		super.signOut();
	}
	
	@Test
	public void listNegative() {
		super.navigatePath("/manager/workPlans/list");
		super.checkErrorsExist();
	}

}
