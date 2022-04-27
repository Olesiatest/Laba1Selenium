package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test4Selenide extends BaseSelenide {

  @Test
  public void windows() throws InterruptedException {
    $(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).scrollIntoView(true)
        .click();

    $(By.xpath("//button[@id='tabButton']")).click();
    switchTo().window(1);
    String sampleHeandingText = $("#sampleHeading").getText();
    String expectedHeadingText = "This is a sample page";
    Assertions.assertThat(expectedHeadingText)
        .as(String.format("%s Actual result is not equal %s", expectedHeadingText,
            sampleHeandingText))
        .isEqualTo(sampleHeandingText);
  }
}



