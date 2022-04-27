package Laba2;

import static com.codeborne.selenide.Selenide.$;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test2Selenide extends BaseSelenide {

  @Test
  public void checkBox2() {

    $(By.xpath("//h5[contains(text(), 'Elements')]")).scrollIntoView(true).click();

    $(By.xpath("//li[@id='item-1']")).scrollIntoView(true).click();

    $(By.xpath("//ol/li//button")).click();

    $(By.xpath("//ol//ol/li[last()]//button")).click();

    $(By.xpath("//label[@for='tree-node-wordFile']")).click();

    String wordFileNew = $(".text-success").getText();
    String expectedResult = "wordFile";
    Assertions.assertThat(expectedResult)
        .as(String.format("%s Actual result is not equal %s", expectedResult, wordFileNew))
        .isEqualTo(wordFileNew);

  }
}


