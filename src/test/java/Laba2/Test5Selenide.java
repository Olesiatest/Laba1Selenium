package Laba2;

import com.codeborne.selenide.Condition;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Test5Selenide extends BaseSelenide{
    @Test
    public void alerts() {
            $(By.xpath("//h5[contains(text()'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).click();

            $(By.xpath("//button[@id='alertButton']")).shouldBe(Condition.visible).click();

            String actualTextInAlert = switchTo().alert().getText();
            String expectedTextInAlert = "You clicked a button";
            Assertions.assertThat(expectedTextInAlert).as("Не верный результат").isEqualTo(actualTextInAlert);
            switchTo().alert().accept();//*Закриття Алерта(модальне вікно).

        }
    }


