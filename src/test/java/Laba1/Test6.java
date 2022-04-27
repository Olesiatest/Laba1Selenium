package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test6 extends Base {

  @Test
  public void alertsSecond() {

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    Utils.scrollToElement(driver, cardAlertFrameWindows);
    action.click(cardAlertFrameWindows).build().perform();

    WebElement alertWindowButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
    Utils.scrollToElement(driver, alertWindowButton);
    action.click(alertWindowButton).build().perform();

    WebElement clickMeButtonInAlertWindowAfterFiveMinutes = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='timerAlertButton']")));
    action.click(clickMeButtonInAlertWindowAfterFiveMinutes).build().perform();
    wait.until(ExpectedConditions.alertIsPresent());
    String actualTextInAlertSecond = driver.switchTo().alert().getText();
    String expectedTextInAlertSecond = "This alert appeared after 5 seconds";
    Assertions.assertThat(expectedTextInAlertSecond)
        .as(String.format("%s Actual result is not equal %s", expectedTextInAlertSecond,
            actualTextInAlertSecond))
        .isEqualTo(actualTextInAlertSecond);
    driver.switchTo().alert().accept();
  }
}

