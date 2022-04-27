package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test5 extends Base {

  @Test
  public void alerts() {

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    Utils.scrollToElement(driver, cardAlertFrameWindows);
    action.click(cardAlertFrameWindows).build().perform();

    WebElement alertWindowButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
    Utils.scrollToElement(driver, alertWindowButton);
    action.click(alertWindowButton).build().perform();

    WebElement clickMeButtonInAlertWindow = wait.until(
        ExpectedConditions.elementToBeClickable(By.id("alertButton")));
    action.click(clickMeButtonInAlertWindow).build().perform();
    wait.until(ExpectedConditions.alertIsPresent());
    String actualTextInAlert = driver.switchTo().alert().getText();
    String expectedTextInAlert = "You clicked a button";
    Assertions.assertThat(expectedTextInAlert)
        .as(String.format("%s Actual result is not equal %s", expectedTextInAlert,
            actualTextInAlert))
        .isEqualTo(actualTextInAlert);
  }
}

