package Laba3;

import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

  private NavigationMenuBlock navigationMenu = new NavigationMenuBlock();

  public NavigationMenuBlock getNavigationMenu() {
    return navigationMenu;
  }

  private final By messageCreatedAccount = By.xpath(
      "//h1[contains (text(), 'Your Account Has Been Created!')]");
  private final By errorFirstName = By.xpath("//div[@class='text-danger']");
  private final By myAccountLogin = By.xpath("//h2[contains(text(),'My Account')]");

  public String textAccountPage() {
    return find(messageCreatedAccount).getText();
  }

  public String getErrorFirstName() {
    return find(errorFirstName).getText();
  }

  public String getMyAccountLogin() {
    return find(myAccountLogin).getText();
  }


}



