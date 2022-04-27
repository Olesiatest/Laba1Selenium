package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test2 extends Base {

  @Test
  public void checkBox() {

    WebElement cardElements = driver.findElement(
        By.xpath("//h5[contains(text(), 'Elements')]"));
    Utils.scrollToElement(driver, cardElements);
    cardElements.click();

    WebElement checkBoxElement = driver.findElement(
        By.id("item-1"));
    checkBoxElement.click();

    WebElement uncollapseHome = driver.findElement(
        By.xpath("//ol/li//button"));
    uncollapseHome.click();

    WebElement unCollapseDownloadHome = driver.findElement(
        By.xpath("//ol//ol/li[last()]//button"));
    unCollapseDownloadHome.click();

    WebElement selectWordFile = driver.findElement(
        By.xpath("//label[@for='tree-node-wordFile']"));
    selectWordFile.click();

    WebElement wordFile = driver.findElement(
        By.xpath("//span[@class='text-success']"));
    String wordFileNew = wordFile.getText();
    String expectedResult = "wordFile";
    Assertions.assertThat(expectedResult)
        .as(String.format("%s Actual result is not equal %s", expectedResult, wordFileNew))
        .isEqualTo(wordFileNew);
  }
}



