@RegistrationPageValidations
Feature: New registration validation tests

  Background: 
    Given I am on registration page "http://myrgo-preprod.ctt.co.uk/register"

  @RegistrationFormSubmissionWithOutCaptcha
  Scenario: Complete the registration form with valid data for all mandatory input fields and submit the form with out captcha
    When I input mobile number and confirm mobile number as "07921213315"
    And I input first name as "MyName"
    And I input surname as "Surname"
    And I input email and confirm email as "mani.yammani14@gmail.com"
    And I input password as "Testpas1"
    And I input confirm password as "Testpas1"
    And I select a secret question and provide secret answer as "TestAnswer"
    And I provide vehicle detials as "DV06UXT" "Blue","Skoda"
    And I provide payment Card details as "4929123123123127","05","15","05","25"
    And I select to agree the Terms & Conditions and Privacy Policy
    Then I click on next button
    Then I can see the error message for captch as "Please complete the Recaptcha."

  @MobileNumberValidation
  Scenario Outline: Mobile number validation
    When I input mobile number and confirm mobile number as "<Mobile Number>"
    Then I can see appropiate message as "<Message>"

    Examples: 
      | Mobile Number | Message                      |
      |   07921213315 | Number available to register |
      |         12345 | Phone number is invalid      |

  @EmailValidation
  Scenario Outline: Email field validation
    When I input email and confirm email as "<Email ID>"
    Then I can see appropiate message for email as "<Message>"

    Examples: 
      | Email ID                 | Message                     |
      | test@test.com            | Email is already in use     |
      | test.com                 | Email is invalid            |
      | mani.yammani14@gmail.com | Email available to register |

  @PasswordFieldValidation
  Scenario Outline: Password field validation
    When I input password as "<Password>"
    Then I can see error message for password as "<Message>"

    Examples: 
      | Password | Message                                                         |
      | TESTPAS1 | Password must be at least eight characters long, and contain at |
      | testpas1 | Password must be at least eight characters long, and contain at |
      | Testpass | Password must be at least eight characters long, and contain at |
      | Testpa1  | Password must be at least eight characters long, and contain at |
      | !0000000 | Password must be at least eight characters long, and contain at |

  @ConfirmPasswordFieldValidation
  Scenario Outline: Confirm Password field validation
    When I input password as "Testpas1"
    And I input confirm password as "<ConfirmPassword>"
    Then I can see error message for confirm password as "<Message>"

    Examples: 
      | ConfirmPassword | Message                    |
      | Testpass        | Passwords are not the same |
      | testpas1        | Passwords are not the same |
