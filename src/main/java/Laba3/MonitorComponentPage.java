package Laba3;

import org.openqa.selenium.By;

public class MonitorComponentPage extends BasePage {

  private final By wishListMonitorApple = By.xpath("//button[@onclick=\"wishlist.add('42');\"]");
  private final By wishListMonitorSamsung = By.xpath("//button[@onclick=\"wishlist.add('33');\"]");
  private final By wishPageUrl = By.xpath("//a[@id='wishlist-total']");


  public MonitorComponentPage addWishListMonitorApple() {
    find(wishListMonitorApple).click();
    return this;
  }

  public MonitorComponentPage addWishListMonitorSamsung() {
    find(wishListMonitorSamsung).click();
    return this;
  }

  public WishListPage clickWishPageUrl() {
    find(wishPageUrl).click();
    return new WishListPage();
  }


}
