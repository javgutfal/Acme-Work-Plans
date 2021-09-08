package acme.testing.anonymous.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousTaskListTest extends AcmeWorkPlansTest {
	
	/* 
	 Test que comprueba que todos los campos del listado de tasks en anonymous son los esperados, al igual que los
	   que aparecen al entrar en el show
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex, final String title, final String initialTime, final String finalTime, final String workload, final String description, final String link, final String publicTask, final String publicTaskShow) {

		super.clickOnMenu("Anonymous", "See tasks");

		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, initialTime);
		super.checkColumnHasValue(recordIndex, 2, finalTime);
		super.checkColumnHasValue(recordIndex, 3, workload);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, link);
		super.checkColumnHasValue(recordIndex, 6, publicTask);

		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
	}
	
	/*
	 Este test intenta acceder al listado de task de Anonymous logeado como manager y 
	 nos devuelve la vista de panic
	 */
	@Test
	public void listNegativeNotAuthorised() {

		super.signIn("manager", "asdf1234");
		super.navigatePath("/anonymous/task/list");		
		super.checkPanicExists();
	}

}
