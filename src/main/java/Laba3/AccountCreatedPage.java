package Laba3;

import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

  private final By messageCreatedAccount = By.xpath(
      "//h1[contains (text(), 'Your Account Has Been Created!')]");

  public String textAccountPage() {
    return getDriver().findElement(messageCreatedAccount).getText();

  }


}
