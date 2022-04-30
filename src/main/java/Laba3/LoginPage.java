package Laba3;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  public final By loginEmailAddress = By.xpath("//input[@id='input-email']");
  public final By loginPassword = By.xpath("//input[@id='input-password']");
  public final By submitButton = By.xpath("//input[@type='submit']");

  public LoginPage fillLoginEmailAddress(String emailAddress) {
    find(loginEmailAddress).sendKeys(emailAddress);
    return this;
  }

  public LoginPage fillPassword(String
      password) {
    find(loginPassword).sendKeys(password);
    return this;
  }

  public AccountCreatedPage clickButton() {
    find(submitButton).click();
    return new AccountCreatedPage();
  }

}


