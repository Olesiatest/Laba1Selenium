package Laba2;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Test9Selenide extends BaseSelenide {

  @Test
  public void progressBar() throws InterruptedException {

    $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();

    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).scrollIntoView(true)
        .click();
    $(By.xpath("//button[@id='startStopButton']")).click();

    SelenideElement progressBar = $(By.xpath("//div[@role='progressbar']"));

    String ariaValuenow = progressBar.attr("aria-valuenow");
    String ariaValuemax = progressBar.attr("aria-valuemax");

    while (Integer.parseInt(ariaValuenow) <= Integer.parseInt(ariaValuemax)) {
      Thread.sleep(100);
      ariaValuenow = progressBar.attr("aria-valuenow");
      if (Integer.parseInt(ariaValuenow) == Integer.parseInt(ariaValuemax)) {
        break;
      }
    }
    $("#resetButton").click();

    ariaValuenow = progressBar.attr("aria-valuenow");
    Assertions.assertThat(Integer.parseInt(ariaValuenow)).as("Прогрес бар равен 0").isEqualTo(0);
  }
}


