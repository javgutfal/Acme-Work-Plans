package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class ManagerTaskListTest extends AcmeWorkPlansTest {

	/*
	 Este test comprueba el listado de task,
	 se espera un resultado positivo.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow) {
		
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
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
		
		super.checkButtonExists("Update Task");
		super.checkButtonExists("Delete Task");
	}
	
	/*
	 Este test intenta acceder al listado sin loguearse como manager,
	 se espera un resultado negativo.
	*/
	@Test
	public void listNegative() {
		super.navigatePath("/manager/task/list");
		super.checkPanicExists();
	}
	
}
