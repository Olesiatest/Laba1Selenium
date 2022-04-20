package Laba3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test(priority = 1)
  public void loginPageTest() {
    MainPage mainPage = new MainPage();
    String actualResult = mainPage.clickOnMyAccountPage().clickOnLoginPage()
        .fillLoginEmailAddress("tabamfbh576@aikusy.com")
        .fillPassword("123456")
        .clickButton()
        .getMyAccountLogin();

    Assertions.assertThat("My Account").as("Ошибка")
        .isEqualTo(actualResult);
  }
}
