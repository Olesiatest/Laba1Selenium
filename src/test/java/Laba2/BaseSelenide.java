package Laba2;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseSelenide {

  @BeforeClass
  public void driverSettingOnSite() {
    Configuration.browser = "chrome";
    Configuration.browserSize = "1366x700";
    Configuration.timeout = 10000;
    open("https://demoqa.com/");
    closeAds();
  }

  public void closeAds() {
    executeJavaScript("return document.getElementById('fixedban').remove();");

  }

}




