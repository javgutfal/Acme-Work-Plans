package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AnonymousShoutListTest extends AcmeWorkPlansTest {
	/* 
	 Test que comprueba que todos los campos del listado de shouts en Anonymous son los esperados
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAll(final int recordIndex, final String moment,final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous", "See shouts");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
		
		
	}

}
