package Laba3;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

  private final By firstnameField = By.xpath("//input[@id='input-firstname']");
  private final By lastnameField = By.xpath("//input[@id='input-lastname']");
  private final By emailField = By.xpath("//input[@id='input-email']");
  private final By telephoneField = By.xpath("//input[@id='input-telephone']");
  private final By passwordField = By.xpath("//input[@id='input-password']");
  private final By confirmField = By.xpath("//input[@id='input-confirm']");
  private final By checkBoxAgree = By.xpath("//input[@name='agree']");
  private final By submitButton = By.xpath("//input[@type='submit']");


  public RegisterPage fillFirstnameField(String firstName) {
    getDriver().findElement(firstnameField).sendKeys(firstName);
    return this;
  }

  public RegisterPage fillLastnameField(String lastName) {
    getDriver().findElement(lastnameField).sendKeys(lastName);
    return this;
  }

  public RegisterPage fillEmailField(String email) {
    getDriver().findElement(emailField).sendKeys(email);
    return this;
  }

  public RegisterPage fillTelephoneField(String telephone) {
    getDriver().findElement(telephoneField).sendKeys(telephone);
    return this;
  }

  public RegisterPage fillPasswordField(String password) {
    getDriver().findElement(passwordField).sendKeys(password);
    return this;
  }

  public RegisterPage fillConfirmField(String password) {
    getDriver().findElement(confirmField).sendKeys(password);
    return this;
  }

  public RegisterPage clickCheckBoxAgree() {
    getDriver().findElement(checkBoxAgree).click();
    return this;
  }

  public AccountCreatedPage clickOnSubmitButton() {
    getDriver().findElement(submitButton).click();
    return new AccountCreatedPage();
  }


}

