package Laba2;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test13Selenide extends BaseSelenide {

  @Test
  public void dynamicProperties() {

    $(By.xpath("//h5[contains(text(), 'Interactions')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true)
        .click();

    SelenideElement first = $(By.xpath("//li[contains(text(), 'Cras justo odio')]"));
    first.click();
    SelenideElement second = $(By.xpath("//li[contains(text(), 'Morbi leo risus')]"));
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

