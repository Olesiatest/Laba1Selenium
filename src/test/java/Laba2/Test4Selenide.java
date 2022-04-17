package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.lang.Thread.sleep;

public class Test4Selenide extends BaseSelenide {

  @Test
  public void windows() throws InterruptedException {
    $(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).scrollIntoView(true)
        .click();

    $(By.xpath("//button[@id='tabButton']")).click();
    switchTo().window(1);
//            String defaultWindow = driver.getWindowHandle();
//            String[] availableWindows = driver.getWindowHandles().toArray(new String[0]);
//            for (int i = 0; i < availableWindows.length; i++) {
//                if (!defaultWindow.equals(availableWindows[i])) {
//                    driver.switchTo().window(availableWindows[i]);
//                    break;
//                }
//            }
    String sampleHeandingText = $("#sampleHeading").getText();
    String expectedHeadingText = "This is a sample page";
    Assertions.assertThat(expectedHeadingText).as("Не корректный текст")
        .isEqualTo(sampleHeandingText);
  }
}


