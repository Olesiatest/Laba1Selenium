package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test7 extends Base {

  @Test
  public void frames() {

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    Utils.scrollToElement(driver, cardAlertFrameWindows);
    action.click(cardAlertFrameWindows).build().perform();

    WebElement frameWindowButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
    Utils.scrollToElement(driver, frameWindowButton);
    action.click(frameWindowButton).build().perform();

    WebElement frameAlert = driver.findElement(By.id("frame1"));
    driver.switchTo().frame(frameAlert);

    String textInFrameAlertsFrameWindow = driver.findElement(By.id("sampleHeading"))
        .getText();
    String expectedTextInFrame = "This is a sample page";
    Assertions.assertThat(expectedTextInFrame)
        .as(String.format("%s Actual result is not equal %s", expectedTextInFrame,
            textInFrameAlertsFrameWindow))
        .isEqualTo(textInFrameAlertsFrameWindow);

  }
}


