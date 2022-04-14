package Laba2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Test13Selenide extends BaseSelenide{

    @Test
    public void dynamicProperties() {

            $(By.xpath("//h5[contains(text(), 'Interactions')]")).scrollIntoView(true).click();
            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']")).scrollIntoView(true).click();

           SelenideElement first = $(By.xpath("//li[contains(text(), 'Cras justo odio')]"));
           first.scrollIntoView(true).click();
           SelenideElement second = $(By.xpath("//li[contains(text(), 'Morbi leo risus')]"));
           second.scrollIntoView(true).click();

            assert first.attr("class").contains("active");
            assert second.attr("class").contains("active");

        }
    }
