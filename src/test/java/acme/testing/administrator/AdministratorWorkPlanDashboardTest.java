package acme.testing.administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorWorkPlanDashboardTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/work-plan-dashboard/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String value) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "WorkPlan Dashboard");
		super.checkColumnDashBoardHasValue(recordIndex, 0, value);
		super.signOut();
	}
	
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/workplandashboard/show");
		super.checkErrorsExist();
	}

}
