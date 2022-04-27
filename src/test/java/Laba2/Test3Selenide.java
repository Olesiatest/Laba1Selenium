package Laba2;

import static com.codeborne.selenide.Selenide.$;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test3Selenide extends BaseSelenide {

  @Test
  public void button2() {
    $(By.xpath("//h5[contains(text(), 'Elements')]")).scrollIntoView(true).click();

    $(By.xpath("//li[@id='item-4']")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='mt-4'][last()]/button")).click();
    String expectedTextClickMeButton = "You have done a dynamic click";
    String dynamicClickMessageText = $("#dynamicClickMessage").getText();
    Assertions.assertThat(expectedTextClickMeButton).as("Не соответствует результат")
        .isEqualTo(dynamicClickMessageText);

    $("#rightClickBtn").contextClick();
    String checkTextRightClick = "You have done a dynamic click";
    String checkOutTextRightText = $("#rightClickMessage").getText();
    Assertions.assertThat(checkTextRightClick).as("Не соответствует результат")
        .isEqualTo(checkOutTextRightText);

    $("#doubleClickBtn").doubleClick();
    String expectedDoubleClickButton = "You have done a double click";

    String actualDoubleClickButton = $("#doubleClickMessage").getText();
    Assertions.assertThat(expectedDoubleClickButton)
        .as(String.format("%s Actual result is not equal %s", expectedDoubleClickButton,
            actualDoubleClickButton))
        .isEqualTo(actualDoubleClickButton);
  }
}


