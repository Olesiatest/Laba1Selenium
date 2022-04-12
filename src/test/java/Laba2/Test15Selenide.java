package Laba2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

public class Test15Selenide extends BaseSelenide{

    @Test
    public void practiceFormSecond() {
        try {
           $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
           $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true).click();

            $("#autoCompleteMultipleInput").shouldBe(Condition.visible).setValue("o");

            SelenideElement colorsMenu = $(By.xpath("//div[contains(@class, 'auto-complete__menu-list')]"));
            String[] threeColor = {"Yellow", "Voilet", "Indigo"};

            List<String> colorsToCheck = Arrays.asList(threeColor);
            List<SelenideElement> colorsEl = colorsMenu.findAll(By.xpath("//div[contains(@class, 'auto-complete__option')]"));
            for (SelenideElement col : colorsEl) {
                assertTrue(colorsToCheck.contains(col.getText()));
            }
            colorsMenu.find(By.xpath("//div[contains(@class, 'auto-complete__option') and contains(text(), 'Voilet')]")).click();


        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}


