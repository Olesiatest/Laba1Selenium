package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test4 extends Base {

  @Test
  public void windows() throws InterruptedException {

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    Utils.scrollToElement(driver, cardAlertFrameWindows);
    action.click(cardAlertFrameWindows).build().perform();

    WebElement browserWindowButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
    Utils.scrollToElement(driver, browserWindowButton);
    action.click(browserWindowButton).build().perform();

    WebElement newTabInBrowserWindows = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("tabButton")));
    action.click(newTabInBrowserWindows).build().perform();
    String defaultWindow = driver.getWindowHandle();
    String[] availableWindows = driver.getWindowHandles().toArray(new String[0]);
    for (int i = 0; i < availableWindows.length; i++) {
      if (!defaultWindow.equals(availableWindows[i])) {
        driver.switchTo().window(availableWindows[i]);
        break;
      }

    }
    String sampleHeandingText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='sampleHeading']")))
        .getText();
    String expectedHeadingText = "This is a sample page";
    Assertions.assertThat(expectedHeadingText)
        .as(String.format("%s Actual result is not equal %s", expectedHeadingText,
            sampleHeandingText))
        .isEqualTo(sampleHeandingText);
  }
}

