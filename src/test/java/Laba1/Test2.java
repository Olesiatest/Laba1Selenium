package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Test2 extends Base{
    @Test
    public void checkBox() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
            WebElement cardElements = driver.findElement(
                    By.xpath("//h5[contains(text(), 'Elements')]"));
            cardElements.click();

            WebElement checkBoxElement = driver.findElement(
                    By.xpath("//li[@id='item-1']"));
            checkBoxElement.click();

            WebElement uncollapseHome = driver.findElement(
                    By.xpath("//ol/li//button"));
            uncollapseHome.click();

            WebElement unCollapseDownloadHome = driver.findElement(
                    By.xpath("//ol//ol/li[last()]//button"));
            unCollapseDownloadHome.click();

            WebElement selectWordFile = driver.findElement(
                    By.xpath("//label[@for='tree-node-wordFile']"));
            selectWordFile.click();

            WebElement wordFile = driver.findElement(
                    By.xpath("//span[@class='text-success']"));
            String wordFileNew = wordFile.getText();
            String expctedResult = "wordFile";
            assertEquals(expctedResult, wordFileNew);


        }
    }


