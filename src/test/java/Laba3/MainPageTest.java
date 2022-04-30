package Laba3;

import blocks.HeaderBlock.CurrencyItems;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

  @Test(priority = 1)
  public void iphoneCheckPrice() {
    MainPage mainPage = new MainPage();
    String selectedCurrency = mainPage.getHeaderBlock().checkCurrencySelected();
    Assertions.assertThat("$").as("Incorrect currency").isEqualTo(selectedCurrency);
    String priceIphone = mainPage.findIphoneTheList()
        .checkPriceIphone();
    Assertions.assertThat("$123.20").as("Incorrect price in USD").isEqualTo(priceIphone);
    IphonePage iphonePage = new IphonePage();
    String priceEuro = iphonePage.getHeaderBlock()
        .currencySelectItem(CurrencyItems.CurrencyEuro, new IphonePage())
        .checkPriceIphone();
    Assertions.assertThat("106.04€").as("Incorrect price in Euro").isEqualTo(priceEuro);

    String priceGBP = iphonePage.getHeaderBlock()
        .currencySelectItem(CurrencyItems.CurrencyGBP, new IphonePage())
        .checkPriceIphone();
    Assertions.assertThat("£95.32").as("Incorrect price in Zloty").isEqualTo(priceGBP);
  }
}

