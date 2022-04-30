package Laba3;

import blocks.HeaderBlock;
import org.openqa.selenium.By;

public class IphonePage extends BasePage {

  private final By priceIphone = By.xpath("//ul//h2");

  public String checkPriceIphone() {
    return find(priceIphone).getText();
  }

  private HeaderBlock headerBlock = new HeaderBlock();

  public HeaderBlock getHeaderBlock() {
    return headerBlock;
  }

}
