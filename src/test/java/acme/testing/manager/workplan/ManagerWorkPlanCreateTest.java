package acme.testing.manager.workplan;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class ManagerWorkPlanCreateTest extends AcmeWorkPlansTest {
	
	// Comprueba el correcto funcionamiento de la creación de varios workplans con diferentes parámetros y comprueba que se añaden a la lista de forma progresiva
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String initialTime, final String finalTime, final String workload, final String publicWorkPlan, final String published, final String publicWorkPlanShow, final String value) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "Create WorkPlans");

		super.fillInputBoxIn("initialTime", initialTime);
		super.fillInputBoxIn("finalTime", finalTime);
		super.fillInputBoxIn("publicWorkPlan", value);
		
		super.clickOnSubmitButton("Create Workplan");

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
	
	// Comprueba que se detectan errores cuando introducimos datos erroneos en la creación de un workplan
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void createNegative(final int recordIndex, final String initialTime, final String finalTime, final String workload, final String publicWorkPlan, final String published, final String publicWorkPlanShow, final String value) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "Create WorkPlans");

		super.fillInputBoxIn("initialTime", initialTime);
		super.fillInputBoxIn("finalTime", finalTime);
		super.fillInputBoxIn("publicWorkPlan", value);
		
		super.clickOnSubmitButton("Create Workplan");

		super.checkErrorsExist();

		super.signOut();
	}

}
