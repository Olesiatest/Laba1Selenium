package Laba3;

import org.openqa.selenium.By;

public class MonitorComponentPage extends BasePage {

  private final By wishListMonitorApple = By.xpath("//button[@onclick=\"wishlist.add('42');\"]");
  private final By wishListMonitorSamsung = By.xpath("//button[@onclick=\"wishlist.add('33');\"]");
  private final By wishPageUrl = By.xpath("//a[@id='wishlist-total']");


  public MonitorComponentPage addWishListMonitorApple() {
    getDriver().findElement(wishListMonitorApple).click();
    return this;
  }

  public MonitorComponentPage addWishListMonitorSamsung() {
    getDriver().findElement(wishListMonitorSamsung).click();
    return this;
  }

  public WishListPage clickWishPageUrl() {
    getDriver().findElement(wishPageUrl).click();
    return new WishListPage();
  }


}
