package Laba2;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

    public class BaseSelenide {
        WebDriver driver;
        Actions action;
        WebDriverWait wait;

        @BeforeClass
        public void driverSettingOnSite() {
            Configuration.browser = "chrome";
            Configuration.browserSize = "1366x500";
            open("https://demoqa.com/");
            closeAds();
        }
        public void closeAds() {
            ((JavascriptExecutor) driver).executeScript("return document.getElementById('fixedban').remove();");
        }

    }

