package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Test15 extends Base {

  @Test
  public void practiceFormSecond() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

    WebElement widgetForms = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    action.click(widgetForms).build().perform();

    ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
    WebElement cardAutoComplete = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
    action.click(cardAutoComplete).build().perform();

    WebElement autocompleteInput = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.id("autoCompleteMultipleInput")));
    autocompleteInput.sendKeys("o");

    WebElement colorsMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("//div[contains(@class, 'auto-complete__menu-list')]")));
    String[] threeColor = {"Yellow", "Voilet", "Indigo"};

    List<String> colorsToCheck = Arrays.asList(threeColor);
    List<WebElement> colorsEl = colorsMenu.findElements(
        By.xpath("//div[contains(@class, 'auto-complete__option')]"));
    for (WebElement col : colorsEl) {
      assertTrue(colorsToCheck.contains(col.getText()));
    }
    WebElement viol = colorsMenu.findElement(By.xpath(
        "//div[contains(@class, 'auto-complete__option') and contains(text(), 'Voilet')]"));
    viol.click();

  }

}
