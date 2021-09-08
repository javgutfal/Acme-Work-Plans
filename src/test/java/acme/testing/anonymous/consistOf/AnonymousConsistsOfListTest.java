package acme.testing.anonymous.consistOf;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousConsistsOfListTest extends AcmeWorkPlansTest{
	/* 
	 Test que comprueba que todos los campos del listado de tasks de un workplan específico
	  en anonymous son los esperados, al igual que los que aparecen al entrar en el show
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/consists-of/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex1,final int recordIndex2, final String title, final String initialTime, final String finalTime, final String workload, final String link, final String description, final String publicTask, final String publicTaskShow) {
		
		super.clickOnMenu("Anonymous", "See workplans");
		
		super.clickOnListingRecord(recordIndex1);
		
		final String url = this.getCurrentUrlComplete();
		final String[] parts = url.split("=");
		final String workplanId = parts[1];
		
		super.navigatePath("/anonymous/task/list-tasks-workplan?id="+workplanId);
		
		super.checkColumnHasValue(recordIndex2, 0, title);
		super.checkColumnHasValue(recordIndex2, 1, initialTime);
		super.checkColumnHasValue(recordIndex2, 2, finalTime);
		super.checkColumnHasValue(recordIndex2, 3, workload);
		super.checkColumnHasValue(recordIndex2, 4, description);
		super.checkColumnHasValue(recordIndex2, 5, link);
		super.checkColumnHasValue(recordIndex2, 6, publicTask);
		
		super.clickOnListingRecord(recordIndex2);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("initialTime", initialTime);
		super.checkInputBoxHasValue("finalTime", finalTime);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("publicTask", publicTaskShow);
		
		
	}
	/*
	 Este test intenta acceder al listado de task de un workplan especifico en Anonymous
	  logeado como manager y nos devuelve la vista de panic
	 */
	@Test
    public void listNegativeNotAuthorised() {

        super.signIn("manager", "asdf1234");
        super.clickOnMenu("Manager", "View workplans");

        super.clickOnListingRecord(0);

        final String url = this.getCurrentUrlComplete();
        final String[] parts = url.split("=");
        final String workplanId = parts[1];

        super.navigatePath("/anonymous/task/list-tasks-workplan?id="+workplanId);

        super.checkPanicExists();
    }
	
}
