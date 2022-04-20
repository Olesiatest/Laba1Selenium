package Laba3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class WishListTest extends BaseTest {

  @Test(priority = 1)
  public void addToWishList() {
    MainPage mainPage = new MainPage();
    int actualProductCount = mainPage.clickOnMyAccountPage().clickOnLoginPage()
        .fillLoginEmailAddress("tabamfbh576@aikusy.com")
        .fillPassword("123456")
        .clickButton()
        .getDropdownComponent()
        .getChooseMonitors()
        .addWishListMonitorApple()
        .addWishListMonitorSamsung()
        .clickWishPageUrl()
        .sumWishListProducts();
    Assertions.assertThat(2).as("Не корректное кол-во товара").isEqualTo(actualProductCount);
    
  }
}
