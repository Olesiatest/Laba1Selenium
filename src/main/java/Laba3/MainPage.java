package Laba3;

import blocks.HeaderBlock;
import blocks.NavigationMenuBlock;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private HeaderBlock headerBlock = new HeaderBlock();

  public HeaderBlock getHeaderBlock() {
    return headerBlock;
  }

  private NavigationMenuBlock navigationMenu = new NavigationMenuBlock();

  public NavigationMenuBlock getNavigationMenu() {
    return navigationMenu;
  }

  private final By findIphone = By.xpath("//a[contains(text(),'iPhone')]");


  public IphonePage findIphoneTheList() {
    find(findIphone).click();
    return new IphonePage();
  }


}
