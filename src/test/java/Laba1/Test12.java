package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test12 extends Base {

  @Test
  public void selectAble() {

    WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    Utils.scrollToElement(driver, cardWidget);
    action.click(cardWidget).build().perform();

    WebElement selectMenuInWidget = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
    Utils.scrollToElement(driver, selectMenuInWidget);
    action.click(selectMenuInWidget).build().perform();

    WebElement dropDownMenu = driver.findElement(By.xpath("//div[@id='selectOne']"));
    action.click(dropDownMenu).build().perform();

    WebElement selectOne = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("selectOne")));
    selectOne.click();

    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[contains(text(), 'Ms.') and not(contains(@class, 'singleValue'))]")));
    option.click();

    String selected = selectOne.findElement(By.xpath("//div[contains(@class, 'singleValue')]"))
        .getText();
    Assertions.assertThat(selected)
        .as(String.format("%s Actual result is not equal %s", selected, "Ms"));

  }
}


