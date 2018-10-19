package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BasePage;

public class RegistrationPage extends BasePage {

	@FindBy(id = "field-Member_CLI")
	private WebElement mobi1eNumber;

	@FindBy(id = "field-Member_CLI_confirm")
	private WebElement confirmMobileNumber;

	@FindBy(id = "field-Member_Firstname")
	private WebElement firstName;

	@FindBy(id = "field-Member_Lastname")
	private WebElement surname;

	@FindBy(id = "field-Member_Email")
	private WebElement email;

	@FindBy(id = "field-Member_Email_confirm")
	private WebElement confirmEmail;

	@FindBy(id = "field-MemberPassword")
	private WebElement password;

	@FindBy(id = "field-MemberPassword_confirm")
	private WebElement confirmPassword;

	@FindBy(id = "field-SecretQuestion")
	private WebElement secretQuestionDropdown;

	@FindBy(id = "field-SecretAnswer")
	private WebElement secretAnswer;

	@FindBy(id = "field-VRN")
	private WebElement numberPlate;

	@FindBy(id = "field-Colour")
	private WebElement colour;

	@FindBy(id = "field-Make")
	private WebElement make;

	@FindBy(id = "field-Member_Ccnumber")
	private WebElement cardNumber;

	@FindBy(id = "field-Member_Ccstart")
	private WebElement cardStartMonth;

	@FindBy(xpath = "//*[@id='header3']/ol/li[2]/div/div/select[2]")
	private WebElement cardStartYear;

	@FindBy(id = "field-Member_Ccexpire")
	private WebElement cardExpiryMonth;

	@FindBy(xpath = "//*[@id='header3']/ol/li[3]/div/div/select[2]")
	private WebElement cardExpiryYear;

	@FindBy(xpath = "//*[@id='header6']/ol/li[1]/div/div/input")
	private WebElement termsAndConditions;

	@FindBy(css = ".labbutton.labdefault.labnext")
	private WebElement nextButton;

	@FindBy(id = "climsgbox")
	private WebElement mobileNumberValidationMsg;

	@FindBy(id = "emailmsgbox")
	private WebElement emailValidationMessage;

	@FindBy(xpath = "//li[12]/div/div/span")
	private WebElement passwordValidationMessage;

	@FindBy(xpath = "//li[13]/div/div/span")
	private WebElement confirmPasswordValidationMessage;

	@FindBy(xpath = "//*[@id='header5']//span")
	private WebElement captchaErrorMessage;

	private final String securityQuestion1 = "Which phone number do you remember most from your childhood?";

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void inputMobileNumberAndConfirmMobileNUmber(String mobileNumber) {
		enterIntoInputField(mobi1eNumber, mobileNumber);
		enterIntoInputField(confirmMobileNumber, mobileNumber);
	}

	public String getMobileNumberValidationMessage() throws InterruptedException {
		Thread.sleep(3000);
		return getText(mobileNumberValidationMsg);
	}

	public void inputEmailAndConfirmEmail(String emailID) {
		enterIntoInputField(email, emailID);
		enterIntoInputField(confirmEmail, emailID);
	}

	public String getEmailValidationMessage() throws InterruptedException {
		Thread.sleep(3000);
		return getText(emailValidationMessage);
	}

	public void inputPassword(String passwordtext) {
		enterIntoInputField(password, passwordtext);
	}

	public String getPasswordValidationMessage() throws InterruptedException {
		Thread.sleep(3000);
		return getText(passwordValidationMessage).replace(" ", "");
	}

	public void inputConfirmPassword(String password2) {
		enterIntoInputField(confirmPassword, password2);
	}

	public String getConfirmPasswordValidationMessage() throws InterruptedException {
		Thread.sleep(3000);
		return getText(confirmPasswordValidationMessage);
	}

	public void inputFirstname(String firstNameText) {
		enterIntoInputField(firstName, firstNameText);

	}

	public void inputSurname(String surnameText) {
		enterIntoInputField(surname, surnameText);

	}

	public void selectSecurityQuestionAndProvideAnswer(String securityAnswer) {
		selectFromDropDown(secretQuestionDropdown, securityQuestion1);
		enterIntoInputField(secretAnswer, securityAnswer);
	}

	public void inputVehicleDetails(String regNO, String colour2, String vMake) {
		scrollToElement(numberPlate);
		enterIntoInputField(numberPlate, regNO);
		selectFromDropDown(colour, colour2);
		selectFromDropDown(make, vMake);

	}

	public void inputPaymentDetails(String carNO, String valFromMon, String valFromYr, String expMon, String expYr) {
		scrollToElement(cardNumber);
		enterIntoInputField(cardNumber, carNO);
		selectFromDropDown(cardStartMonth, valFromMon);
		selectFromDropDown(cardStartYear, valFromYr);
		selectFromDropDown(cardExpiryMonth, expMon);
		selectFromDropDown(cardExpiryYear, expYr);
	}

	public void acceptTermsAndConditions() {
		scrollToElement(termsAndConditions);
		tickCheckbox(termsAndConditions);
	}

	public void clickNextButton() {
		nextButton.click();
	}

	public String getCaptchErrorMessage() throws InterruptedException {
		Thread.sleep(3000);
		scrollToElement(termsAndConditions);
		return getText(captchaErrorMessage);
	}

}
