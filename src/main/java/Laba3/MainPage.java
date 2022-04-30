package Laba3;

import blocks.HeaderBlock;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private HeaderBlock headerBlock = new HeaderBlock();

  public HeaderBlock getHeaderBlock() {
    return headerBlock;
  }

  private final By findIphone = By.xpath("//a[contains(text(),'iPhone')]");


  public IphonePage findIphoneTheList() {
    find(findIphone).click();
    return new IphonePage();
  }


}
