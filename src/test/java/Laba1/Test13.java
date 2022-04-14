package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test13 extends Base{
    @Test
    public void dynamicProperties() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            WebElement cardInteractions = driver.findElement(By.xpath("//h5[contains(text(), 'Interactions')]"));
            action.click(cardInteractions).build().perform();
            ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
            WebElement selectMenuInWidget = driver.findElement(By.xpath("//span[contains(text(), 'Selectable')]"));
            action.click(selectMenuInWidget).build().perform();
            ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
            WebElement menuSelectuble = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
            action.click(menuSelectuble).build().perform();

            WebElement first = driver.findElement(By.xpath("//li[contains(text(), 'Cras justo odio')]"));
            first.click();
            WebElement second = driver.findElement(By.xpath("//li[contains(text(), 'Morbi leo risus')]"));
            second.click();

            assert first.getAttribute("class").contains("active");
            assert second.getAttribute("class").contains("active");

        }
    }

