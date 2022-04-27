package Laba2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test10Selenide extends BaseSelenide {

  @Test
  public void tabs() {
    $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']")).scrollIntoView(true)
        .click();
    List<SelenideElement> tabsListWidget = $$(By.xpath("//a[@role='tab']"));
    List<String> activeTexts = Arrays.asList("What", "Origin", "Use");
    for (SelenideElement tab : tabsListWidget) {
      boolean isDisabled = tab.getAttribute("class").contains("disabled");
      if (activeTexts.contains(tab.getText())) {
        Assertions.assertThat(isDisabled)
            .as(String.format("%b Actual result is not equal,false", isDisabled)).isFalse();
      } else {
        Assertions.assertThat(isDisabled)
            .as(String.format("%s tab is not disabled", tab.getText())).isTrue();
      }
    }
  }
}


