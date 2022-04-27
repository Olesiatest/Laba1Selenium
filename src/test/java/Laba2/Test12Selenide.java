package Laba2;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test12Selenide extends BaseSelenide {

  @Test
  public void selectAble() {

    $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']")).scrollIntoView(true)
        .click();
    $("#selectOne").scrollIntoView(true).click();

    SelenideElement selectOne = $(
        By.xpath("//div[contains(text(), 'Ms.') and not(contains(@class, 'singleValue'))]"));
    selectOne.shouldBe(Condition.visible).scrollIntoView("Ms.").click();

    String selected = selectOne.find(By.xpath("//div[contains(@class, 'singleValue')]")).getText();
    Assertions.assertThat(selected)
        .as(String.format("%s Actual result is not equal %s", selected, "Ms"));

  }
}

