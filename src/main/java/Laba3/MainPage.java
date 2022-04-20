package Laba3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

  private final By myAccountPage = By.xpath("//a[@title='My Account']");
  private final By registerPage = By.xpath("//a[contains( text(), 'Register')]");
  private final By loginPage = By.xpath("//a[contains( text(), 'Login')]");

  public MainPage clickOnMyAccountPage() {
    new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(
        ExpectedConditions.elementToBeClickable(myAccountPage)).click();
//    getDriver().findElement(myAccountPage).click();
    return this;
  }

  public RegisterPage clickOnRegisterPage() {
    getDriver().findElement(registerPage).click();
    return new RegisterPage();
  }

  public LoginPage clickOnLoginPage() {
    getDriver().findElement(loginPage).click();
    return new LoginPage();
  }


}
