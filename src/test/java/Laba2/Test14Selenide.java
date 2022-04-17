package Laba2;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Test14Selenide extends BaseSelenide {

  @Test
  public void practiceForm() {
    $(By.xpath("//h5[contains(text(), 'Forms')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).scrollIntoView(true)
        .shouldBe(visible).click();
    $("#submit").shouldBe(exist).scrollIntoView(true).click();
    String firstNameField = $("#firstName").getCssValue("border-color");
    String errorColor = "rgb(206, 212, 218)";
    Assertions.assertThat(errorColor).as("Ошибки нету").isEqualTo(firstNameField);

    String dateOfBirthInput = $("#dateOfBirthInput").attr("value");
    SimpleDateFormat formatForDate = new SimpleDateFormat("dd MMM yyyy", new Locale("en", "EN"));
    String currentDate = formatForDate.format(new Date());
    Assertions.assertThat(currentDate).as("Не верна дата").isEqualTo(dateOfBirthInput);
  }
}






