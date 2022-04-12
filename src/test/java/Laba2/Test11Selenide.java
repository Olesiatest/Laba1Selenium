package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Test11Selenide extends BaseSelenide{
    @Test
    public void selectMenu() {
        try {
          $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
          $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']")).scrollIntoView(true).click();

            Select select = new Select($("#soldSelectMenu"));
            select.selectByVisibleText("White");
            String chooseColorBox = select.getFirstSelectedOption().getText();
            Assertions.assertThat("White").as("Выбран не правильный вариант").isEqualTo(chooseColorBox);

        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
