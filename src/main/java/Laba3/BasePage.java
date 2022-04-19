package Laba3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.openqa.selenium.WebDriver;

public abstract class BasePage {

  private static WebDriver driver;
//  protected static void setDriver driver;

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }
  public static WebDriver getDriver(){
    return driver;
  }

//  protected WebElement find(By locator) {
//    return getDriver().findElement(locator);
//  }
//
//  protected WebElement waitUntilVisible(By locator,int seconds) {
//    return new WebDriverWait(getDriver(),seconds)
//        .until(ExpectedConditions.visibilityOfElementLocated(locator));
//  }



}
