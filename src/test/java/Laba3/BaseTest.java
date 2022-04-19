package Laba3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demo.opencart.com/index.php?route=common/home");
    BasePage.setDriver(driver);
  }

  @AfterMethod
  public void closeDriver() {
    BasePage.getDriver().quit();
  }

}
