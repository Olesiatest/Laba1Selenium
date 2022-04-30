package Laba3;

import blocks.HeaderBlock.MenuItems;
import blocks.NavigationMenuBlock.MenuNavComponents;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest {

  @Test(priority = 1)
  public void addToWishList() {

    MainPage mainPage = new MainPage();
    int actualProductCount = mainPage.getHeaderBlock()
        .selectMenuItem(MenuItems.LOGIN, new LoginPage())
        .fillLoginEmailAddress("tabamfbh576@aikusy.com")
        .fillPassword("123456")
        .clickButton()
        .getNavigationMenu()
        .selectItemFromNavMenu(MenuNavComponents.MONITORS, new MonitorComponentPage())
        .addWishListMonitorApple()
        .addWishListMonitorSamsung()
        .clickWishPageUrl()
        .sumWishListProducts();
    Assertions.assertThat(2).as("Count goods is not correct").isEqualTo(actualProductCount);
  }
}
