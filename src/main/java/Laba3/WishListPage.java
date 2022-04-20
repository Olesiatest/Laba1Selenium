package Laba3;

import org.openqa.selenium.By;

public class WishListPage extends BasePage {

  private final By wishListProducts = By.xpath("//tbody/tr");

  public int sumWishListProducts() {
    return getDriver().findElements(wishListProducts).size();
  }
}
