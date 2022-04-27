package Laba1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Utils;

public class Test14 extends Base {

  @Test
  public void practiceForm() {

    ((JavascriptExecutor) driver).executeScript(
        "return document.getElementById('fixedban').remove();");
    WebElement cardForms = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]"));
    Utils.scrollToElement(driver, cardForms);
    action.click(cardForms).build().perform();

    WebElement clickMenuPracticeButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")));
    Utils.scrollToElement(driver, clickMenuPracticeButton);
    action.click(clickMenuPracticeButton).build().perform();

    ((JavascriptExecutor) driver).executeScript("scrollTo(0,document.body.scrollHeight)");
    ((JavascriptExecutor) driver).executeScript(
        "return document.getElementById('submit').click();");

    String firstNameField = driver.findElement(By.id("firstName"))
        .getCssValue("border-color");
    String errorColor = "rgb(206, 212, 218)";
    Assertions.assertThat(errorColor)
        .as(String.format("%s Actual result is not equal %s", errorColor, firstNameField))
        .isEqualTo(firstNameField);

    String dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"))
        .getAttribute("value");
    SimpleDateFormat formatForDate = new SimpleDateFormat("dd MMM yyyy", new Locale("en", "EN"));
    String currentDate = formatForDate.format(new Date());
    Assertions.assertThat(currentDate)
        .as(String.format("%s Actual result is not equal %s", currentDate, dateOfBirthInput))
        .isEqualTo(dateOfBirthInput);
  }
}


