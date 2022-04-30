package Laba3;

import blocks.HeaderBlock.MenuItems;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test(priority = 1)
  public void loginPageTest() {
    MainPage mainPage = new MainPage();
    String actualResult = mainPage.getHeaderBlock().selectMenuItem(MenuItems.LOGIN, new LoginPage())
        .fillLoginEmailAddress("tabamfbh576@aikusy.com")
        .fillPassword("123456")
        .clickButton()
        .getMyAccountLogin();

    Assertions.assertThat("My Account").as("Invalid login")
        .isEqualTo(actualResult);
  }
}
