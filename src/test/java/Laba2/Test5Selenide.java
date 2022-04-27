package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test5Selenide extends BaseSelenide {

  @Test
  public void alerts() {
    $(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true)
        .click();

    $("#alertButton").shouldBe(Condition.visible).click();

    String actualTextInAlert = switchTo().alert().getText();
    String expectedTextInAlert = "You clicked a button";
    Assertions.assertThat(expectedTextInAlert)
        .as(String.format("%s Actual result is not equal %s", expectedTextInAlert,
            actualTextInAlert))
        .isEqualTo(actualTextInAlert);

  }
}



