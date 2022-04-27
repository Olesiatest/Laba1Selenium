package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test7Selenide extends BaseSelenide {

  @Test
  public void frames() {
    $(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")).scrollIntoView(true).click();

    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']")).scrollIntoView(true)
        .click();

    SelenideElement frameAlert = $("#frame1");
    switchTo().frame(frameAlert);

    String textInFrameAlertsFrameWindow = $("#sampleHeading").getText();
    String expectedTextInFrame = "This is a sample page";
    Assertions.assertThat(expectedTextInFrame)
        .as(String.format("%s Actual result is not equal %s", expectedTextInFrame,
            textInFrameAlertsFrameWindow))
        .isEqualTo(textInFrameAlertsFrameWindow);
  }
}



