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

public class Test6Selenide extends BaseSelenide{
    @Test
    public void alertsSecond() {
        try {
            $(By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]")).scrollIntoView(true).click();

            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true).click();

            $("#timerAlertButton").shouldBe(Condition.visible).scrollIntoView(true).click();

            String actualTextInAlertSecond = switchTo().alert().getText();
            String expectedTextInAlertSecond = "This alert appeared after 5 seconds";
            Assertions.assertThat(expectedTextInAlertSecond).as("Не верный результат").isEqualTo(actualTextInAlertSecond);
            switchTo().alert().accept();//*Закриття Алерта(модальне вікно).
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }

    }
}


