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
    return find(messageCreatedAccount).getText();
  }

  public String getErrorFirstName() {
    return find(errorFirstName).getText();
  }

  public String getMyAccountLogin() {
    return find(myAccountLogin).getText();
  }

  public AccountCreatedPage getDropdownComponent() {
    Actions actions = new Actions(getDriver());
    actions.moveToElement(find(chooseDropdownComponent)).build().perform();
    return this;
  }

  public MonitorComponentPage getChooseMonitors() {
    find(chooseMonitors).click();
    return new MonitorComponentPage();
  }


}



