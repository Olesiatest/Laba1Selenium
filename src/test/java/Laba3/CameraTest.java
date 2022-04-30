package Laba3;

import blocks.NavigationMenuBlock.MenuNavComponents;
import org.testng.annotations.Test;

public class CameraTest extends BaseTest {

  @Test(priority = 1)
  public void checkCameraListPrice() {
    MainPage mainPage = new MainPage();
    mainPage.getNavigationMenu().selectItemFromNavMenu(MenuNavComponents.CAMERS, new CameraPage())


  }


}
