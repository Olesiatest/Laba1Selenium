package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test3 extends Base {
    @Test
    public void button() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardElements = driver.findElement(
                    By.xpath("//h5[contains(text(), \"Elements\")]"));
            action.click(cardElements).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            WebElement buttonElement = driver.findElement(
                    By.xpath("//li[@id='item-4']"));
            action.click(buttonElement).build().perform();

            Thread.sleep(1000);
            WebElement buttonElementMeClick = driver.findElement(By.xpath("//div[@class='mt-4'][last()]/button"));
            action.click(buttonElementMeClick).build().perform();
            String expectedTextClickMeButton = "You have done a dynamic click";
            String dynamicClickMessageText = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText();
            Assertions.assertThat(expectedTextClickMeButton).as("Не соответствует результат").isEqualTo(dynamicClickMessageText);
//            WebElement rightClickMe = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
//            action.contextClick(rightClickMe).build().perform();
//            String expectedTextRightClick="You have done a dynamic click";
//            String actualTextRightClickResult = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
//            Assertions.assertThat(expectedTextRightClick).as("Не соответствует результат").isEqualTo(actualTextRightClickResult);//**помилковий тест.

            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
            WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));//** <button id="doubleClickBtn">Double Click Me</button>
            action.doubleClick(doubleClickButton).build().perform();
            String expectedDoubleClickButton = "You have done a double click";
            String actualDoubleClickButton = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
            Assertions.assertThat(expectedDoubleClickButton).as("Не соответствует результат").isEqualTo(actualDoubleClickButton);
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
