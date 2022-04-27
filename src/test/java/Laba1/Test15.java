package Laba1;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test15 extends Base {

  @Test
  public void practiceFormSecond() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    WebElement widgetForms = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    Utils.scrollToElement(driver, widgetForms);
    action.click(widgetForms).build().perform();

    WebElement cardAutoComplete = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
    Utils.scrollToElement(driver, cardAutoComplete);
    action.click(cardAutoComplete).build().perform();

    WebElement autocompleteInput = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.id("autoCompleteMultipleInput")));
    autocompleteInput.sendKeys("o");

    List<String> colorsToCheck = new ArrayList<>();

    List<WebElement> colorElements = driver.findElements(
        By.xpath("//div[contains(@class, 'auto-complete__option')]"));
    for (int i = 0; i < colorElements.size(); i++) {
      String color = colorElements.get(i).getText();
      colorsToCheck.add(color);
    }
    Assertions.assertThat(colorsToCheck).as("Actual result is not equals expected")
        .containsExactlyInAnyOrder("Yellow", "Violet", "Indigo");
  }
}

