package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test15Selenide extends BaseSelenide {

  @Test
  public void practiceFormSecond() {
    $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true)
        .click();

    $("#autoCompleteMultipleInput").shouldBe(Condition.visible).setValue("o");

    List<String> colorsToCheck = new ArrayList<>();

    List<SelenideElement> colorElements = $$(
        By.xpath("//div[contains(@class, 'auto-complete__option')]"));
    for (int i = 0; i < colorElements.size(); i++) {
      String color = colorElements.get(i).getText();
      colorsToCheck.add(color);
    }
    Assertions.assertThat(colorsToCheck).as("Actual result is not equals expected")
        .containsExactlyInAnyOrder("Yellow", "Violet", "Indigo");
  }
}