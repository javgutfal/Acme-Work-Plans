package acme.testing.administrator.percent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorPercentUpdateTest extends AcmeWorkPlansTest{
	
	/* Con este test comprobamos que si estamos logeados como administrator podemos modificar correctamente a un valor de porcentaje
	   válido comprobando nuevamente tras actualizar el valor que se encuentra tanto en el listado como en el show*/
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updatePositive(final int recordIndex, final String prevValue,final String value) {		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Percents list");		
		
		super.checkColumnHasValue(recordIndex, 1, prevValue);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("data", value);

		
		super.clickOnSubmitButton("Update");
		
		super.checkColumnHasValue(recordIndex, 1, value);

		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("data", value);

		
		
		super.signOut();
	}
	
	/* Comprobamos que con varios ejemplos negativos el test falla y por tanto las restricciones se están cumpliendo correctamente
	   las restricciones violadas a probar son valor mayor a 100, valor que no sea un double y que el valor debe ser superior a 0*/
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/percent/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateNegative(final int recordIndex, final String prevValue,final String value) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Percents list");		
		
		super.checkColumnHasValue(recordIndex, 1, prevValue);
			
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("data", value);
		
		super.clickOnSubmitButton("Update");

		super.checkErrorsExist();
		
		super.signOut();
	}
}
