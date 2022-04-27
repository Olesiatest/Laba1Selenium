package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test13 extends Base {

  @Test
  public void dynamicProperties() {

    WebElement cardInteractions = driver.findElement(
        By.xpath("//h5[contains(text(), 'Interactions')]"));
    Utils.scrollToElement(driver, cardInteractions);
    action.click(cardInteractions).build().perform();

    WebElement selectMenuInWidget = driver.findElement(
        By.xpath("//span[contains(text(), 'Selectable')]"));
    Utils.scrollToElement(driver, selectMenuInWidget);
    action.click(selectMenuInWidget).build().perform();

    WebElement menuSelectuble = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
    Utils.scrollToElement(driver, menuSelectuble);
    action.click(menuSelectuble).build().perform();

    WebElement first = driver.findElement(By.xpath("//li[contains(text(), 'Cras justo odio')]"));
    first.click();
    WebElement second = driver.findElement(By.xpath("//li[contains(text(), 'Morbi leo risus')]"));
    second.click();

    String firstAttribute = first.getAttribute("class");
    String secondAttribute = second.getAttribute("class");
    Assertions.assertThat(firstAttribute.contains("active"))
        .as(String.format("%b Actual result is not equal true", firstAttribute.contains("active")))
        .isTrue();
    Assertions.assertThat(secondAttribute.contains("active"))
        .as(String.format("%b Actual result is not equal true", secondAttribute.contains("active")))
        .isTrue();

  }
}

