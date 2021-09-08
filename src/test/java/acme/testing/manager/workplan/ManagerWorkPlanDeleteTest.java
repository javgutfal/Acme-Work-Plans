package acme.testing.manager.workplan;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class ManagerWorkPlanDeleteTest extends AcmeWorkPlansTest {
	
	// Comprueba el correcto funcionamiento del borrado de un registro de workplan, y que en el listado ya no aparece una vez se ha realizado la operación
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void deletePositive(final int recordIndex, final String initialTime, final String finalTime, final String workload, final String publicWorkPlan, final String published, final String publicWorkPlanShow, 
		final String nextInitialTime, final String nextFinalTime, final String nextWorkload, final String nextPublicWorkPlan, final String nextPublished, final String nextPublicWorkPlanShow) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");

		super.checkColumnHasValue(recordIndex, 0, initialTime);
		super.checkColumnHasValue(recordIndex, 1, finalTime);
		super.checkColumnHasValue(recordIndex, 2, workload);
		super.checkColumnHasValue(recordIndex, 3, publicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, published);
		
		super.clickOnListingRecord(recordIndex);
		
		super.clickOnSubmitButton("Delete Workplan");

		super.clickOnMenu("Manager", "View workplans");
		
		super.checkColumnHasValue(recordIndex, 0, nextInitialTime);
		super.checkColumnHasValue(recordIndex, 1, nextFinalTime);
		super.checkColumnHasValue(recordIndex, 2, nextWorkload);
		super.checkColumnHasValue(recordIndex, 3, nextPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, nextPublished);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("initialTime", nextInitialTime);
		super.checkInputBoxHasValue("finalTime", nextFinalTime);
		super.checkInputBoxHasValue("publicWorkPlan", nextPublicWorkPlanShow);
		
		super.signOut();
	}
	
	// Comprueba la existencia de un panic al intentar acceder a la url de borrado sin permisos
	@Test
	public void deleteNegative() {
		super.navigatePath("/manager/workPlans/delete");
		super.checkPanicExists();
	}

}
