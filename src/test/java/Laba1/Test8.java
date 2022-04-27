package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test8 extends Base {

  @Test
  public void modals() {

    WebElement cardAlertFrameWindows = driver.findElement(
        By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    Utils.scrollToElement(driver, cardAlertFrameWindows);
    action.click(cardAlertFrameWindows).build().perform();

    WebElement modalDialogButton = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
    Utils.scrollToElement(driver, modalDialogButton);
    action.click(modalDialogButton).build().perform();

    WebElement smallModalButton = driver.findElement(By.id("showSmallModal"));
    action.click(smallModalButton).build().perform();

    String actualModalTitleDialog = driver.findElement(
        By.xpath("//div[@id='example-modal-sizes-title-sm']")).getText();
    String expectedModalTitleDialog = "Small Modal";
    Assertions.assertThat(expectedModalTitleDialog)
        .as(String.format("%s Actual result is not equal %s", expectedModalTitleDialog,
            actualModalTitleDialog))
        .isEqualTo(actualModalTitleDialog);

    String actualModalTextDialog = driver.findElement(By.xpath("//div[@class='modal-body']"))
        .getText();
    String expectedModalTextDialog = "This is a small modal. It has very less content";
    Assertions.assertThat(expectedModalTextDialog)
        .as(String.format("%s Actual result is not equal %s", expectedModalTextDialog,
            actualModalTextDialog))
        .isEqualTo(actualModalTextDialog);

    WebElement closeModalWindow = driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
    action.click(closeModalWindow).build().perform();

    Boolean theModalIsNotOpen = wait.until(
        ExpectedConditions.attributeToBe(By.tagName("body"), "class", ""));
    Assertions.assertThat(theModalIsNotOpen)
        .as(String.format("%b Actual result is not equal true", theModalIsNotOpen))
        .isTrue();


  }
}


