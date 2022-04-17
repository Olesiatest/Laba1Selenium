package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test3 extends Base {

  @Test
  public void button() throws InterruptedException {
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    WebElement cardElements = driver.findElement(
        By.xpath("//h5[contains(text(), 'Elements')]"));
    action.click(cardElements).build().perform();

    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    WebElement buttonElement = driver.findElement(
        By.xpath("//li[@id='item-4']"));
    action.click(buttonElement).build().perform();

    Thread.sleep(1000);
    WebElement buttonElementMeClick = driver.findElement(
        By.xpath("//div[@class='mt-4'][last()]/button"));
    action.click(buttonElementMeClick).build().perform();
    String expectedTextClickMeButton = "You have done a dynamic click";
    String dynamicClickMessageText = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"))
        .getText();
    Assertions.assertThat(expectedTextClickMeButton).as("Не соответствует результат")
        .isEqualTo(dynamicClickMessageText);

    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
    WebElement doubleClickButton = driver.findElement(By.xpath(
        "//button[@id='doubleClickBtn']"));//** <button id="doubleClickBtn">Double Click Me</button>
    action.doubleClick(doubleClickButton).build().perform();
    String expectedDoubleClickButton = "You have done a double click";
    String actualDoubleClickButton = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"))
        .getText();
    Assertions.assertThat(expectedDoubleClickButton).as("Не соответствует результат")
        .isEqualTo(actualDoubleClickButton);

  }
}

