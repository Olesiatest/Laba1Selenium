package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Utils;

public class Test11 extends Base {

  @Test
  public void selectMenu() {

    WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
    Utils.scrollToElement(driver, cardWidget);
    action.click(cardWidget).build().perform();
    WebElement selectMenuInWidget = driver.findElement(
        By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
    Utils.scrollToElement(driver, selectMenuInWidget);
    action.click(selectMenuInWidget).build().perform();

    Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
    select.selectByVisibleText("White");
    String chooseColorBox = select.getFirstSelectedOption().getText();
    Assertions.assertThat("White").as(String.format("%s Actual result is not equal %s", "White",
        chooseColorBox)).isEqualTo(chooseColorBox);


  }
}


