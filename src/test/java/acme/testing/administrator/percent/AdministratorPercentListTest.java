package acme.testing.administrator.percent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorPercentListTest extends AcmeWorkPlansTest{
	
	/* Este test comprueba que tanto el listado como el sohw de percent son accesibles logeado como administrator y dan el valor
	   esperado en el csv que el cargado por el sample-data  */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPositive(final int recordIndex, final String code, final String data) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Percents list");

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, data);
		
		super.clickOnListingRecord(recordIndex);

		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("data", data);
		
		super.signOut();
	}
	
	/* Con este test comprobamos que si intentamos ver el listado de porcentajes sin ser administrador nos devuelve a la vista de panic
	   las restricciones violadas a probar son valor mayor a 100, valor que no sea un double y que el valor debe ser superior a 0*/
	
	@Test
	public void listNegative() {
		super.navigatePath("/administrator/variable/percent/list");
		super.checkPanicExists();
	}
}
