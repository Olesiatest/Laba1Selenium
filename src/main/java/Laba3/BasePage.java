package Laba3;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

  private static WebDriver driver;
//  protected static void setDriver driver;

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  protected WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  protected List<WebElement> findElements(By locator) {
    return getDriver().findElements(locator);
  }
//
//  protected WebElement waitUntilVisible(By locator,int seconds) {
//    return new WebDriverWait(getDriver(),seconds)
//        .until(ExpectedConditions.visibilityOfElementLocated(locator));
//  }


}
