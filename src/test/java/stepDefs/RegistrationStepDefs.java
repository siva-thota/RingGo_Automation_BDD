package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegistrationPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RegistrationStepDefs {
	private RegistrationPage registrationPage;
	public WebDriver driver;

	public RegistrationStepDefs() {
		driver = Hooks.driver;
		registrationPage = new RegistrationPage(driver);
	}

	@Given("^I am on registration page \"([^\"]*)\"$")
	public void i_am_on_registration_page(String url) throws Throwable {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Runtime.getRuntime().exec(classLoader.getResource("util/AutoITScript.exe").getPath());
		driver.get(url);
	}

	@When("^I input mobile number and confirm mobile number as \"([^\"]*)\"$")
	public void i_input_mobile_number_and_confirm_mobile_number_as(String mobileNumber) throws Throwable {
		registrationPage.inputMobileNumberAndConfirmMobileNUmber(mobileNumber);
	}

	@Then("^I can see appropiate message as \"([^\"]*)\"$")
	public void i_can_see_appropiate_message_as(String msg) throws Throwable {
		assertEquals(registrationPage.getMobileNumberValidationMessage(), msg);
	}

	@When("^I input email and confirm email as \"([^\"]*)\"$")
	public void i_input_email_and_confirm_email_as(String email) throws Throwable {
		registrationPage.inputEmailAndConfirmEmail(email);
	}

	@Then("^I can see appropiate message for email as \"([^\"]*)\"$")
	public void i_can_see_appropiate_message_for_email_as(String msg) throws Throwable {
		assertEquals(registrationPage.getEmailValidationMessage(), msg);
	}

	@When("^I input password as \"([^\"]*)\"$")
	public void i_input_password_as(String password) throws Throwable {
		registrationPage.inputPassword(password);
	}

	@Then("^I can see error message for password as \"(.*?)\"$")
	public void i_can_see_error_message_for_password_as(String msg) throws Throwable {
		assertTrue(registrationPage.getPasswordValidationMessage().contains(msg.replace(" ", "")));
	}

	@Then("^I can see error message for confirm password as \"(.*?)\"$")
	public void i_can_see_error_message_for_confirm_password_as(String msg) throws Throwable {
		assertEquals(registrationPage.getConfirmPasswordValidationMessage(), msg);
	}

	@When("^I input confirm password as \"([^\"]*)\"$")
	public void i_input_confirm_password_as(String password) throws Throwable {
		registrationPage.inputConfirmPassword(password);
	}

	@When("^I input first name as \"([^\"]*)\"$")
	public void i_input_first_name_as(String firstName) throws Throwable {
		registrationPage.inputFirstname(firstName);
	}

	@When("^I input surname as \"([^\"]*)\"$")
	public void i_input_surname_as(String surname) throws Throwable {
		registrationPage.inputSurname(surname);
	}

	@When("^I select a secret question and provide secret answer as \"([^\"]*)\"$")
	public void i_select_a_secret_question_and_provide_secret_answer_as(String securityAnswer) throws Throwable {
		registrationPage.selectSecurityQuestionAndProvideAnswer(securityAnswer);
	}

	@When("^I provide vehicle detials as \"([^\"]*)\" \"([^\"]*)\",\"([^\"]*)\"$")
	public void i_provide_vehicle_detials_as(String regNO, String colour, String vMake) throws Throwable {
		registrationPage.inputVehicleDetails(regNO, colour, vMake);
	}

	@When("^I provide payment Card details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_provide_payment_Card_details_as(String carNO, String valFromMon, String valFromYr, String expMon,
			String expYr) throws Throwable {
		registrationPage.inputPaymentDetails(carNO, valFromMon, valFromYr, expMon, expYr);
	}

	@When("^I select to agree the Terms & Conditions and Privacy Policy$")
	public void i_select_to_agree_the_Terms_Conditions_and_Privacy_Policy() throws Throwable {
		registrationPage.acceptTermsAndConditions();
	}

	@Then("^I click on next button$")
	public void i_click_on_next_button() throws Throwable {
		registrationPage.clickNextButton();
	}

	@Then("^I can see the error message for captch as \"([^\"]*)\"$")
	public void i_can_see_the_error_message_for_captch_as(String msg) throws Throwable {
		assertEquals(registrationPage.getCaptchErrorMessage(), msg);
	}

}
