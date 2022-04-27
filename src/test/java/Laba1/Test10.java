package Laba1;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test10 extends Base {

  @Test
  public void tabs() {

    WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    Utils.scrollToElement(driver, cardWidget);
    action.click(cardWidget).build().perform();

    WebElement tabsButtonInWidget = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']"));
    Utils.scrollToElement(driver, tabsButtonInWidget);
    action.click(tabsButtonInWidget).build().perform();
    WebElement elementWhatTabsInWidget = driver.findElement(By.id("demo-tab-what"));

    List<WebElement> tabsListWidget = driver.findElements(By.xpath("//a[@role='tab']"));
    List<String> activeTexts = Arrays.asList("What", "Origin", "Use");

    for (WebElement tab : tabsListWidget) {
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

