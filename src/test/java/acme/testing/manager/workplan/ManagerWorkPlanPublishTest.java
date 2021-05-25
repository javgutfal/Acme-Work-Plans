
package acme.testing.manager.workplan;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerWorkPlanPublishTest extends AcmePlannerTest {

	// Test que comprueba el correcto funcionamiento del método publicar de los workplans y comprueba posteriormente su actualización en la lista
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void publishPositive(final int recordIndex, final String prevInitialTime, final String prevFinalTime, final String prevWorkload, final String prevPublicWorkPlan, final String prevPublished, final String prevPublicWorkPlanShow,
		final String newInitialTime, final String newFinalTime, final String newWorkload, final String newPublicWorkPlan, final String newPublished, final String newPublicWorkPlanShow) {

		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");

		super.checkColumnHasValue(recordIndex, 0, prevInitialTime);
		super.checkColumnHasValue(recordIndex, 1, prevFinalTime);
		super.checkColumnHasValue(recordIndex, 2, prevWorkload);
		super.checkColumnHasValue(recordIndex, 3, prevPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, prevPublished);

		super.clickOnListingRecord(recordIndex);

		final String url = this.getCurrentUrlComplete();
		final String[] parts = url.split("=");
		final String workplanId = parts[1];

		super.navigatePath("/manager/workPlans/publish?id=" + workplanId);

		super.fillInputBoxIn("initialTime", newInitialTime);
		super.fillInputBoxIn("finalTime", newFinalTime);

		super.clickOnSubmitButton("Publish Workplan");

		super.checkColumnHasValue(recordIndex, 0, newInitialTime);
		super.checkColumnHasValue(recordIndex, 1, newFinalTime);
		super.checkColumnHasValue(recordIndex, 2, newWorkload);
		super.checkColumnHasValue(recordIndex, 3, newPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, newPublished);

		super.signOut();
	}

	// Comprueba que se detectan errores cuando introducimos datos erroneos en la publicación de un workplan
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/work-plan/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void publishNegative(final int recordIndex, final String prevInitialTime, final String prevFinalTime, final String prevWorkload, final String prevPublicWorkPlan, final String prevPublished, final String prevPublicWorkPlanShow,
		final String newInitialTime, final String newFinalTime, final String newWorkload, final String newPublicWorkPlan, final String newPublished, final String newPublicWorkPlanShow) {

		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "View workplans");

		super.checkColumnHasValue(recordIndex, 0, prevInitialTime);
		super.checkColumnHasValue(recordIndex, 1, prevFinalTime);
		super.checkColumnHasValue(recordIndex, 2, prevWorkload);
		super.checkColumnHasValue(recordIndex, 3, prevPublicWorkPlan);
		super.checkColumnHasValue(recordIndex, 4, prevPublished);

		super.clickOnListingRecord(recordIndex);

		final String url = this.getCurrentUrlComplete();
		final String[] parts = url.split("=");
		final String workplanId = parts[1];

		super.navigatePath("/manager/workPlans/publish?id=" + workplanId);

		super.fillInputBoxIn("initialTime", newInitialTime);
		super.fillInputBoxIn("finalTime", newFinalTime);

		super.clickOnSubmitButton("Publish Workplan");

		super.checkErrorsExist();;

		super.signOut();
	}

}
