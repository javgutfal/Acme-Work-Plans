package acme.testing.administrator;

import org.junit.jupiter.api.Test;

import acme.testing.AcmePlannerTest;

public class AdministratorWorkPlanDashboardTest extends AcmePlannerTest{
	
	@Test
	public void listPositive() {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "WorkPlan Dashboard");
		super.signOut();
	}
	
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/workplandashboard/show");
		super.checkErrorsExist();
	}

}
