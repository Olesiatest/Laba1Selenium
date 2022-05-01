package blocks;

import Laba3.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductItemBlock extends BasePage {

  private WebElement foundProduct = null;

  private Actions actions;

  public enum PriceParams {
    PRICENEW, PRICEOLD, PRICETAX
  }


  public ProductItemBlock() {
    actions = new Actions(getDriver());
  }

  private final By productItem = By.xpath("//div[contains(@class,'product-thumb')]");
  private final By productName = By.xpath("//div[@class='caption']/h4/a");
  private final By productCanon = By.xpath("//a[contains(text(),'Canon EOS 5D')]");
  private final By productNikon = By.xpath(" //a[contains(text(),'Nikon D300')]");
  private final By priceNew = By.xpath("//span[@class='price-new']");
  private final By priceOld = By.xpath("//span[@class='price-old']");
  private final By priceTax = By.xpath("//span[@class='price-tax']");
  private final By addToWishList = By.xpath("//button[@data-original-title='Add to Wish List']");

  public int getCountProduct() {
    return findElements(productItem).size();
  }

  public WebElement findElementByName(String name) {
    List<WebElement> products = findElements(productItem);

    for (WebElement product : products) {
      String productText = product.findElement(productName).getText();
      if (productText.equals(name)) {
        foundProduct = product;
      }
    }
    return foundProduct;
  }

  public String getPriceProduct(By priceLocator) {
    return foundProduct.findElement(priceLocator).getText();
  }

  public String findPriceParam(PriceParams item) {
    switch (item) {
      case PRICENEW:
        return getPriceProduct(priceNew);
      case PRICEOLD:
        return getPriceProduct(priceOld);
      case PRICETAX:
        return getPriceProduct(priceTax);
      default:
        throw new IllegalStateException("Unexpected param " + item);

    }

  }


}
