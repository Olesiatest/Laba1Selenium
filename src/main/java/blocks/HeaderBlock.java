package blocks;

import Laba3.BasePage;
import org.openqa.selenium.By;


public class HeaderBlock extends BasePage {

  public enum MenuItems {
    LOGIN, REGISTER
  }

  public enum CurrencyItems {
    CurrencyEuro, CurrencyGBP
  }

  //*Currency
  private final By currencyEuro = By.xpath("//button[@name='EUR']");
  private final By currencyGBP = By.xpath("//button[@name='GBP']");
  private final By currencyDropdown = By.xpath("//button/span[contains(text(), 'Currency')]");
  //*HeaderMenu
  private final By myAccountPage = By.xpath("//a[@title='My Account']");
  private final By registerPage = By.xpath("//a[contains( text(), 'Register')]");
  private final By loginPage = By.xpath("//a[contains( text(), 'Login')]");
  private final By currencySelected = By.xpath("//button/strong");


  public HeaderBlock clickOnMyAccountPage() {
    find(myAccountPage).click();
    return this;
  }

  public HeaderBlock clickOnRegisterPage() {
    find(registerPage).click();
    return this;
  }

  public HeaderBlock clickOnLoginPage() {
    find(loginPage).click();
    return this;
  }

  public String checkCurrencySelected() {
    return find(currencySelected).getText();
  }

  public <T extends BasePage> T selectMenuItem(MenuItems item, T returnClass) {
    switch (item) {
      case LOGIN:
        clickOnMyAccountPage().clickOnLoginPage();
        return returnClass;

      case REGISTER:
        clickOnMyAccountPage().clickOnRegisterPage();
        return returnClass;

      default:
        throw new IllegalStateException("Unexpected value" + item);
    }
  }

  public HeaderBlock openDropdownMenu() {
    find(currencyDropdown).click();
    return this;
  }

  public HeaderBlock changeCurrencyFromDropdownToEuro() {
    find(currencyEuro).click();
    return this;
  }

  public HeaderBlock changeCurrencyFromDropdownToGBP() {
    find(currencyGBP).click();
    return this;
  }

  public <T extends BasePage> T currencySelectItem(CurrencyItems item, T returnClass) {
    switch (item) {
      case CurrencyEuro:
        openDropdownMenu().changeCurrencyFromDropdownToEuro();
        return returnClass;

      case CurrencyGBP:
        openDropdownMenu().changeCurrencyFromDropdownToGBP();
        return returnClass;

      default:
        throw new IllegalStateException("Unexpected value" + item);
    }
  }

}


