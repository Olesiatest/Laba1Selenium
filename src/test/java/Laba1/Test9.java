package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test9 extends Base {

  @Test
  public void progressBar() throws InterruptedException {

    WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    Utils.scrollToElement(driver, cardWidget);
    action.click(cardWidget).build().perform();

    WebElement progressBurButtonInWidget = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
    Utils.scrollToElement(driver, progressBurButtonInWidget);
    action.click(progressBurButtonInWidget).build().perform();
    WebElement elementStarButtonProgressBur = driver.findElement(
        By.id("startStopButton"));
    action.click(elementStarButtonProgressBur).build().perform();

    WebElement progressBar = driver.findElement(By.xpath("//div[@role='progressbar']"));
    String ariaValuenow = progressBar.getAttribute("aria-valuenow");
    String ariaValuemax = progressBar.getAttribute("aria-valuemax");
    while (Integer.parseInt(ariaValuenow) <= Integer.parseInt(ariaValuemax)) {
      ariaValuenow = progressBar.getAttribute("aria-valuenow");
      if (Integer.parseInt(ariaValuenow) == Integer.parseInt(ariaValuemax)) {
        break;
      }
    }
    WebElement resetButtonProgressBar = driver.findElement(By.id("resetButton"));
    resetButtonProgressBar.click();
    ariaValuenow = progressBar.getAttribute("aria-valuenow");
    Assertions.assertThat(Integer.parseInt(ariaValuenow))
        .as(String.format("%s Actual result is not equal %d", ariaValuenow, 0)).isEqualTo(0);
  }
}


