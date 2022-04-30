package blocks;

import Laba3.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductItemBlock extends BasePage {

  private Actions actions;

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
    WebElement foundProduct = null;
    for (WebElement product : products) {
      if (product.getText().equals(name)) {
        foundProduct = product;
      } else {
        throw new IllegalStateException("The element not found by this name " + name);
      }
    }
    return foundProduct;
  }


}
