package Laba3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--disable-site-isolation-trials");
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().maximize();
    driver.get("https://demo.opencart.com/");
    BasePage.setDriver(driver);
  }

  @AfterMethod
  public void closeDriver() {
    BasePage.getDriver().quit();
  }

}
