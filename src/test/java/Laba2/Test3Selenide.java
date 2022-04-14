package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Test3Selenide extends BaseSelenide {
    @Test
    public void button2() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
            $(By.xpath("//h5[contains(text(), 'Elements')]")).click();

            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            $(By.xpath("//li[@id='item-4']")).click();

            $(By.xpath("//div[@class='mt-4'][last()]/button")).click();
            String expectedTextClickMeButton = "You have done a dynamic click";

            String dynamicClickMessageText = $("#dynamicClickMessage").getText();
             Assertions.assertThat(expectedTextClickMeButton).as("Не соответствует результат").isEqualTo(dynamicClickMessageText);
//
            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

             $("#doubleClickBtn").doubleClick();
            String expectedDoubleClickButton = "You have done a double click";

            String actualDoubleClickButton =$("#doubleClickMessage").getText();
            Assertions.assertThat(expectedDoubleClickButton).as("Не соответствует результат").isEqualTo(actualDoubleClickButton);
         }
    }

