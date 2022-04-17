package Laba2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Test10Selenide extends BaseSelenide {

  @Test
  public void tabs() {
    $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']")).scrollIntoView(true)
        .click();
    List<SelenideElement> tabsListWidget = $$(By.xpath("//a[@role='tab']"));
    List<String> activeTexts = Arrays.asList("What", "Origin", "Use");
    for (SelenideElement tab : tabsListWidget) {
        if (activeTexts.contains(tab.getText())) {
            assert !tab.attr("class").contains("disabled");
        } else {
            assert tab.attr("class").contains("disabled");
        }
    }
  }
}


