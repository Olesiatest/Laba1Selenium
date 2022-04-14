package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Test12 extends Base{
    @Test
    public void selectAble() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
            action.click(cardWidget).build().perform();
            ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
            WebElement selectMenuInWidget = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
            action.click(selectMenuInWidget).build().perform();

            WebElement dropDownMenu = driver.findElement(By.xpath("//div[@id='selectOne']"));
            action.click(dropDownMenu).build().perform();


            WebElement selectOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectOne")));
            selectOne.click();

            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Ms.') and not(contains(@class, 'singleValue'))]")));
            option.click();

            String selected = selectOne.findElement(By.xpath("//div[contains(@class, 'singleValue')]")).getText();
            assertEquals("Ms.", selected);

        }
    }

