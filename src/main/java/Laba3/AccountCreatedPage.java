package Laba3;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AccountCreatedPage extends BasePage {

  private final By messageCreatedAccount = By.xpath(
      "//h1[contains (text(), 'Your Account Has Been Created!')]");
  private final By errorFirstName = By.xpath("//div[@class='text-danger']");
  private final By myAccountLogin = By.xpath("//h2[contains(text(),'My Account')]");
  private final By chooseDropdownComponent = By.xpath("//a[contains(text(),'Components')]");
  private final By chooseMonitors = By.xpath("//a[contains(text(),'Monitors (2)')]");


  public String textAccountPage() {
    return getDriver().findElement(messageCreatedAccount).getText();
  }

  public String getErrorFirstName() {
    return getDriver().findElement(errorFirstName).getText();
  }

  public String getMyAccountLogin() {
    return getDriver().findElement(myAccountLogin).getText();
  }

  public AccountCreatedPage getDropdownComponent() {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(getDriver().findElement(chooseDropdownComponent)).build().perform();
    return this;
  }

  public MonitorComponentPage getChooseMonitors() {
    getDriver().findElement(chooseMonitors).click();
    return new MonitorComponentPage();
  }


}



