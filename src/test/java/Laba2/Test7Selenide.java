package Laba2;

import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Test7Selenide extends BaseSelenide{
    @Test
    public void frames() {
        try{
        $(By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]")).scrollIntoView(true).click();

        $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']")).scrollIntoView(true).click();

            SelenideElement frameAlert = $("#frame1");
            switchTo().frame(frameAlert);//**переключення до iframe

            String textInFrameAlertsFrameWindow = $("#sampleHeading").getText();
            String expectedTextInFrame = "This is a sample page";
            Assertions.assertThat(expectedTextInFrame).as("Не корректный результат").isEqualTo(textInFrameAlertsFrameWindow);
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}


