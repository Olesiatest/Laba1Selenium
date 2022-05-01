package Laba3;

import blocks.NavigationMenuBlock.MenuNavComponents;
import blocks.ProductItemBlock.PriceParams;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CameraTest extends BaseTest {

  @Test(priority = 1)
  public void checkCameraListPrice() {
    MainPage mainPage = new MainPage();
    int count = mainPage.getNavigationMenu()
        .selectItemFromNavMenu(MenuNavComponents.CAMERS, new CameraPage())
        .productCount();
    Assertions.assertThat(2).as("The counts is not equal two").isEqualTo(count);
    CameraPage cameraPage = new CameraPage();
    String priceOld = cameraPage.getProductByName("Canon EOS 5D").getProductItemBlock()
        .findPriceParam(PriceParams.PRICEOLD);
    Assertions.assertThat("$122.00").as("The price is not  correct").isEqualTo(priceOld);

    String priceNew = cameraPage.getProductByName("Canon EOS 5D").getProductItemBlock()
        .findPriceParam(PriceParams.PRICENEW);
    Assertions.assertThat("$98.00").as("The price is not correct").isEqualTo(priceNew);

    String priceTax = cameraPage.getProductByName("Nikon D300").getProductItemBlock()
        .findPriceParam(PriceParams.PRICETAX);
    Assertions.assertThat("$80.00").as("The price is not correct")
        .isEqualTo(priceTax.substring(priceTax.indexOf(":") + 1).trim());
  }

}
