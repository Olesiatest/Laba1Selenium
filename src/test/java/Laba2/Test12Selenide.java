package Laba2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class Test12Selenide extends BaseSelenide{
    @Test
    public void selectAble() {

            $(By.xpath("//h5[contains(text(), 'Widgets')]")).scrollIntoView(true).click();
            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']")).scrollIntoView(true).click();
            $("#selectOne").scrollIntoView(true).click();

            $("#selectOne").scrollIntoView(true).shouldBe(Condition.visible).click();

           SelenideElement selectOne= $(By.xpath("//div[contains(text(), 'Ms.') and not(contains(@class, 'singleValue'))]"));
           selectOne.scrollIntoView(true).shouldBe(Condition.visible).click();

            String selected = selectOne.find(By.xpath("//div[contains(@class, 'singleValue')]")).getText();
            assertEquals("Ms.",  selected);

        }
    }
