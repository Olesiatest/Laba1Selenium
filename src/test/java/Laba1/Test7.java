package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test7 extends Base {

  @Test
  public void frames() {
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    action.click(cardAlertFrameWindows).build().perform();

    ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
    WebElement frameWindowButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"));
    action.click(frameWindowButton).build().perform();

    WebElement frameAlert = driver.findElement(By.xpath("//iframe[@id='frame1']"));
    driver.switchTo().frame(frameAlert);

    String textInFrameAlertsFrameWindow = driver.findElement(By.xpath("//h1[@id='sampleHeading']"))
        .getText();
    String expectedTextInFrame = "This is a sample page";
    Assertions.assertThat(expectedTextInFrame).as("Не корректный результат")
        .isEqualTo(textInFrameAlertsFrameWindow);

  }
}


