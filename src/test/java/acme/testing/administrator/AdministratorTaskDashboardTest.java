package acme.testing.administrator;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorTaskDashboardTest extends AcmeWorkPlansTest {
	
	/*
	 Este test comprueba todas las filas del dashboard enlazado a task, se espera un resultado positivo
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/task-dashboard/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String value) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Task Dashboard");
		super.checkColumnDashBoardHasValue(recordIndex, 0, value);
		super.signOut();
	}
	
	/*
	 Este test intenta acceder a la vista sin loguearse como administrador,
	 se espera un resultado negativo
	 */
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/taskdashboard/show");
		super.checkPanicExists();
	}
	
}
