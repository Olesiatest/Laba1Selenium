package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test6Selenide extends BaseSelenide {

  @Test
  public void alertsSecond() {

    $(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true)
        .click();

    $("#timerAlertButton").shouldBe(Condition.visible).click();

    String actualTextInAlertSecond = switchTo().alert().getText();
    String expectedTextInAlertSecond = "This alert appeared after 5 seconds";
    Assertions.assertThat(expectedTextInAlertSecond)
        .as(String.format("%s Actual result is not equal %s", expectedTextInAlertSecond,
            actualTextInAlertSecond))
        .isEqualTo(actualTextInAlertSecond);
  }

}



