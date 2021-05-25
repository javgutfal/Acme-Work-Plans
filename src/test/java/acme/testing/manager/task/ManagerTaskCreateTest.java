package acme.testing.manager.task;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ManagerTaskCreateTest  extends AcmePlannerTest {
	
	/*
		Este test crea varias tasks nuevas y comprueba que la creación ha sido realizada 
		con éxito comprobando posteriormente que estas se encuentran en el listado.
		Se espera un resultado positivo.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String title, final String initialTime, final String finalTime, final String workload, final String description, final String link, final String publicTask, final String publicTaskShow, final String value) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "Create task");

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("initialTime", initialTime);
		super.fillInputBoxIn("finalTime", finalTime);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("publicTask", value);
		
		super.clickOnSubmitButton("Create Task");

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
		
		super.signOut();
	}
	
	/* 
		Esta test intenta crear tasks que no complen las validaciones.
		Se espera un resultado negativo.
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createNegative(final int recordIndex, final String title, final String initialTime, final String finalTime, final String workload, final String description, final String link, final String publicTask, final String publicTaskShow, final String value) {
		
		super.signIn("manager", "asdf1234");
		super.clickOnMenu("Manager", "Create task");

		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("initialTime", initialTime);
		super.fillInputBoxIn("finalTime", finalTime);
		super.fillInputBoxIn("workload", workload);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("publicTask", value);
		
		super.clickOnSubmitButton("Create Task");

		super.checkErrorsExist();

		super.signOut();
	}
	
}
