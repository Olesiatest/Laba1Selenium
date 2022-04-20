package Laba3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

  @Test(priority = 1)
  public void iphoneCheckPrice() {
    MainPage mainPage = new MainPage();
//    String actualResult = mainPage.clickOnMyAccountPage().clickOnLoginPage()
    String selectedCurrency = mainPage.checkCurrencySelected();
    Assertions.assertThat("$").as("Не корректна выбрана валюта").isEqualTo(selectedCurrency);
    String priceIphone = mainPage.findIphoneTheList()
        .checkPriceIphone();
    Assertions.assertThat("$123.20").as("Не верная цена").isEqualTo(priceIphone);
    IphonePage iphonePage = new IphonePage();
    String priceEuro = iphonePage.openDropdownMenu()
        .changeCurrencyFromDropdownToEuro()
        .checkPriceIphone();
    Assertions.assertThat("106.04€").as("Не правильная цена в Євро").isEqualTo(priceEuro);

    String priceGBP = iphonePage.openDropdownMenu()
        .changeCurrencyFromDropdownToGBP()
        .checkPriceIphone();
    Assertions.assertThat("£95.32").as("Не правильная цена в Злотих").isEqualTo(priceGBP);


  }
}
