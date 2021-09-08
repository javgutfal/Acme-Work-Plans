package acme.testing.manager.workplan;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class ManagerWorkPlanUpdateTest extends AcmeWorkPlansTest {
	
	// Comprueba el correcto funcionamiento de la actualización de workplans y comprueba que los valores en la lista y en el detalle de dicho workplan se muestran actualizados
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updatePositive(final int recordIndex, final String prevInitialTime, final String prevFinalTime, final String prevWorkload, final String prevPublicWorkPlan, final String prevPublished, final String prevPublicWorkPlanShow, 
		final String newInitialTime, final String newFinalTime, final String newWorkload, final String newPublicWorkPlan, final String newPublished, final String newPublicWorkPlanShow, final String newValue) {		
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");

		super.checkColumnHasValue(recordIndex, 0, prevInitialTime);
		super.checkColumnHasValue(recordIndex, 1, prevFinalTime);
		super.checkColumnHasValue(recordIndex, 2, prevWorkload);
		super.checkColumnHasValue(recordIndex, 3, prevPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, prevPublished);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("initialTime", newInitialTime);
		super.fillInputBoxIn("finalTime", newFinalTime);
		super.fillInputBoxIn("publicWorkPlan", newValue);
		
		super.clickOnSubmitButton("Update Workplan");
		
		super.checkColumnHasValue(recordIndex, 0, newInitialTime);
		super.checkColumnHasValue(recordIndex, 1, newFinalTime);
		super.checkColumnHasValue(recordIndex, 2, newWorkload);
		super.checkColumnHasValue(recordIndex, 3, newPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, newPublished);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("initialTime", newInitialTime);
		super.checkInputBoxHasValue("finalTime", newFinalTime);
		super.checkInputBoxHasValue("publicWorkPlan", newPublicWorkPlanShow);
		
		super.signOut();
	}
	
	// Comprueba que se detectan errores cuando introducimos datos erroneos en la actualización de un workplan
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateNegative(final int recordIndex, final String prevInitialTime, final String prevFinalTime, final String prevWorkload, final String prevPublicWorkPlan, final String prevPublished, final String prevPublicWorkPlanShow, 
		final String newInitialTime, final String newFinalTime, final String newWorkload, final String newPublicWorkPlan, final String newPublished, final String newPublicWorkPlanShow, final String newValue) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");

		super.checkColumnHasValue(recordIndex, 0, prevInitialTime);
		super.checkColumnHasValue(recordIndex, 1, prevFinalTime);
		super.checkColumnHasValue(recordIndex, 2, prevWorkload);
		super.checkColumnHasValue(recordIndex, 3, prevPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, prevPublished);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("initialTime", newInitialTime);
		super.fillInputBoxIn("finalTime", newFinalTime);
		super.fillInputBoxIn("publicWorkPlan", newValue);
		
		super.clickOnSubmitButton("Update Workplan");

		super.checkErrorsExist();

		super.signOut();
	}

}
