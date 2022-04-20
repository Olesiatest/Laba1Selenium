package Laba3;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

  public final By loginEmailAddress = By.xpath("//input[@id='input-email']");
  public final By loginPassword = By.xpath("//input[@id='input-password']");
  public final By submitButton = By.xpath("//input[@type='submit']");

  public LoginPage fillLoginEmailAddress(String emailAddress) {
    getDriver().findElement(loginEmailAddress).sendKeys(emailAddress);
    return this;
  }

  public LoginPage fillPassword(String password) {
    getDriver().findElement(loginPassword).sendKeys(password);
    return this;
  }

  public AccountCreatedPage clickButton() {
    getDriver().findElement(submitButton).click();
    return new AccountCreatedPage();
  }

}


