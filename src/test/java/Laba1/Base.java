package Laba1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class Base {

  WebDriver driver;
  Actions action;
  WebDriverWait wait;

  @BeforeClass
  public void driverSettingOnSite() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    action = new Actions(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://demoqa.com/");
    closeAds();
  }

  public void closeAds() {
    ((JavascriptExecutor) driver).executeScript(
        "return document.getElementById('fixedban').remove();");
  }

  @AfterMethod
  public void closedBrowser() {
    driver.quit();
  }
}


