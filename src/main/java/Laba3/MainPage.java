package Laba3;

import org.openqa.selenium.By;

public class MainPage extends BasePage{
  private final By myAccountPage = By.xpath("//a[@title='My Account']");
  private final By registerPage = By.xpath("//a[contains( text(), 'Register')]");

  public MainPage clickOnMyAccountPage(){
    getDriver().findElement(myAccountPage).click();
    return this;
  }
  public RegisterPage clickOnRegisterPage(){
    getDriver().findElement(registerPage).click();
    return new RegisterPage();
  }


}
