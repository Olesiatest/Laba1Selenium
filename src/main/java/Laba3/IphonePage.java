package Laba3;

import org.openqa.selenium.By;

public class IphonePage extends BasePage {

  private final By priceIphone = By.xpath("//ul//h2");
  private final By currencyEuro = By.xpath("//button[@name='EUR']");
  private final By currencyGBP = By.xpath("//button[@name='GBP']");
  private final By currencyDropdown = By.xpath("//button/span[contains(text(), 'Currency')]");


  public String checkPriceIphone() {
    return getDriver().findElement(priceIphone).getText();
  }

  public IphonePage openDropdownMenu() {
    getDriver().findElement(currencyDropdown).click();
    return this;
  }

  public IphonePage changeCurrencyFromDropdownToEuro() {
    getDriver().findElement(currencyEuro).click();
    return this;
  }

  public IphonePage changeCurrencyFromDropdownToGBP() {
    getDriver().findElement(currencyGBP).click();
    return this;
  }


}
