package Laba3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

  private final By myAccountPage = By.xpath("//a[@title='My Account']");
  private final By registerPage = By.xpath("//a[contains( text(), 'Register')]");
  private final By loginPage = By.xpath("//a[contains( text(), 'Login')]");
  private final By currencySelected = By.xpath("//button/strong");
  private final By findIphone = By.xpath("//a[contains(text(),'iPhone')]");


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

  public String checkCurrencySelected() {
    return getDriver().findElement(currencySelected).getText();
  }


  public IphonePage findIphoneTheList() {
    getDriver().findElement(findIphone).click();
    return new IphonePage();
  }


}
