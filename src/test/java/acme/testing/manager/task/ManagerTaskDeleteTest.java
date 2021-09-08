package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class ManagerTaskDeleteTest extends AcmeWorkPlansTest {

	/*
		Este test borra una task y comprueba que no esté en el listado tras borrarla,
		mirando que la siguiente task del listado a ocupado el lugar de la task borrada.
		Se espera un resultado positivo.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void deletePositive(final int recordIndex, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow,
		final String nextTitle, final String nextInitialTime, final String nextFinalTime, final String nextWorkload, final String nextLink, final String nextDescription, final String nextPublicTask, final String nextPublicTaskShow) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "See tasks");

		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, initialTime);
		super.checkColumnHasValue(recordIndex, 2, finalTime);
		super.checkColumnHasValue(recordIndex, 3, workload);
		super.checkColumnHasValue(recordIndex, 4, link);
		super.checkColumnHasValue(recordIndex, 5, description);
		super.checkColumnHasValue(recordIndex, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex);
		
		super.clickOnSubmitButton("Delete Task");

		super.clickOnMenu("Manager", "See tasks");
		
		super.checkColumnHasValue(recordIndex, 0, nextTitle);
		super.checkColumnHasValue(recordIndex, 1, nextInitialTime);
		super.checkColumnHasValue(recordIndex, 2, nextFinalTime);
		super.checkColumnHasValue(recordIndex, 3, nextWorkload);
		super.checkColumnHasValue(recordIndex, 4, nextLink);
		super.checkColumnHasValue(recordIndex, 5, nextDescription);
		super.checkColumnHasValue(recordIndex, 6, nextPublicTask);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("title", nextTitle);
		super.checkInputBoxHasValue("initialTime", nextInitialTime);
		super.checkInputBoxHasValue("finalTime", nextFinalTime);
		super.checkInputBoxHasValue("workload", nextWorkload);
		super.checkInputBoxHasValue("link", nextLink);
		super.checkInputBoxHasValue("description", nextDescription);
		super.checkInputBoxHasValue("publicTask", nextPublicTaskShow);
		
		super.signOut();
	}

	/*
	 Este test intenta acceder al borrado sin loguearse como manager.
	 Se espera un resultado negativo.
	*/
	@Test
	public void deleteNegative() {
		super.navigatePath("/manager/task/delete");
		super.checkPanicExists();
	}
	
}
