package acme.testing;

import org.hibernate.internal.util.StringHelper;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import acme.framework.testing.AbstractTest;

public abstract class AcmePlannerTest extends AcmeTest{

	// Internal state ---------------------------------------------------------

	// Lifecycle management ---------------------------------------------------

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(false);
		
		this.navigateHome();
		this.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Populate DB (samples)");
		super.checkAlertExists(true);		
		this.signOut();
	}

	// Business methods -------------------------------------------------------
	
	protected void signIn(final String username, final String password) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		
		super.navigateHome();
		super.clickOnMenu("Sign in", null);
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("remember", "true");
		super.clickOnSubmitButton("Sign in");
		super.checkSimplePath("/master/welcome");
		super.checkLinkExists("Account");
	}

	protected void signOut() {
		super.navigateHome();
		super.clickOnMenu("Sign out", null);
		super.checkSimplePath("/master/welcome");
	}

	protected void signUp(final String username, final String password, final String name, final String surname, final String email) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		assert !StringHelper.isBlank(name);
		assert !StringHelper.isBlank(surname);
		assert !StringHelper.isBlank(email);
		// phone is nullable

		super.navigateHome();
		super.clickOnMenu("Sign up", null);	
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.fillInputBoxIn("accept", "true");
		super.clickOnSubmitButton("Sign up");
		super.checkSimplePath("/master/welcome");
	}
	
	protected void signUpFail(final String username, final String password, final String name, final String surname, final String email) {
		assert !StringHelper.isBlank(username);
		assert !StringHelper.isBlank(password);
		assert !StringHelper.isBlank(name);
		assert !StringHelper.isBlank(surname);
		assert !StringHelper.isBlank(email);
		// phone is nullable

		super.navigateHome();
		super.clickOnMenu("Sign up", null);	
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.fillInputBoxIn("accept", "true");
		super.clickOnSubmitButton("Sign up");
		super.checkErrorsExist();
	}

	protected void navigatePath(final String path) {
		//assert this.isSimplePath(path);
		this.navigate(() -> {
			String url;

			url = String.format("%s%s", this.baseUrl, path);
			this.driver.get(url);
			this.longSleep();
		});
	}
	
	protected String getCurrentUrlComplete() {
		String result;
		String urlSimple;
		int counter;

		this.waitUntilComplete();
		result = this.driver.getCurrentUrl();
		urlSimple = this.extractSimplePath(result);
		for (counter = 0; counter < AbstractTest.MAX_URL_FETCH_ATTEMPTS && result.equals("/master/referrer"); counter++) {
			this.sleep(counter + 1, true);
			result = this.driver.getCurrentUrl();
			urlSimple = this.extractSimplePath(result);
		}	
		assert !urlSimple.equals("/master/referrer") : "The '/master/referrer' redirector didn't work";

		return result;
	}
	
	protected void clickOnButton(final String label) {
		assert !StringHelper.isBlank(label);

		By locator;

		locator = By.xpath(String.format("//button[normalize-space()='%s']", label));
		super.clickAndWait(locator);
	}

}
