package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test3 extends Base {

  @Test
  public void button() throws InterruptedException {

    WebElement cardElements = driver.findElement(
        By.xpath("//h5[contains(text(), 'Elements')]"));
    Utils.scrollToElement(driver, cardElements);
    action.click(cardElements).build().perform();

    WebElement buttonElement = driver.findElement(
        By.id("item-4"));
    Utils.scrollToElement(driver, buttonElement);
    action.click(buttonElement).build().perform();

    WebElement buttonElementMeClick = driver.findElement(
        By.xpath("//div[@class='mt-4'][last()]/button"));
    action.click(buttonElementMeClick).build().perform();

    String expectedTextClickMeButton = "You have done a dynamic click";
    String dynamicClickMessageText = driver.findElement(By.id("dynamicClickMessage"))
        .getText();
    Assertions.assertThat(expectedTextClickMeButton)
        .as(String.format("%s Actual result is not equal %s", expectedTextClickMeButton,
            dynamicClickMessageText))
        .isEqualTo(dynamicClickMessageText);

    WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
    Utils.scrollToElement(driver, doubleClickButton);
    action.doubleClick(doubleClickButton).build().perform();

    String expectedDoubleClickButton = "You have done a double click";
    String actualDoubleClickButton = driver.findElement(By.id("doubleClickMessage"))
        .getText();
    Assertions.assertThat(expectedDoubleClickButton)
        .as(String.format("%s Actual result is not equal %s", expectedDoubleClickButton,
            actualDoubleClickButton))
        .isEqualTo(actualDoubleClickButton);
  }
}

