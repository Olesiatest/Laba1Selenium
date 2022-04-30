package blocks;

import Laba3.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class NavigationMenuBlock extends BasePage {


  private Actions actions;

  public NavigationMenuBlock() {
    actions = new Actions(getDriver());
  }

  public enum MenuNavComponents {
    CAMERS, MONITORS
  }

  private final By chooseDropdownComponent = By.xpath("//a[contains(text(),'Components')]");
  private final By chooseMonitors = By.xpath("//a[contains(text(),'Monitors (2)')]");
  private final By chooseCamers = By.xpath(
      "//ul[contains(@class, 'nav') ]/li[not(contains(@class, 'dropdown'))]/a[contains(text(),'Cameras')]");

  public NavigationMenuBlock getDropdownComponent() {
    actions.moveToElement(find(chooseDropdownComponent)).build().perform();
    return this;
  }

  public NavigationMenuBlock getChooseMonitors() {
    find(chooseMonitors).click();
    return this;
  }

  public NavigationMenuBlock clickCameras() {
    find(chooseCamers).click();
    return this;
  }

  public <T extends BasePage> T selectItemFromNavMenu(MenuNavComponents item, T returnClass) {
    switch (item) {
      case CAMERS:
        clickCameras();
        return returnClass;

      case MONITORS:
        getDropdownComponent().getChooseMonitors();

        return returnClass;

      default:
        throw new IllegalStateException("Unexpected value" + item);
    }
  }
}



