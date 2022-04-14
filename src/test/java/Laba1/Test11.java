package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test11 extends Base{
    @Test
    public void selectMenu() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

        WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
            action.click(cardWidget).build().perform();
            ((JavascriptExecutor) driver).executeScript("scroll(0,700)");
            WebElement selectMenuInWidget = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']"));
            action.click(selectMenuInWidget).build().perform();

            Select select = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
            select.selectByVisibleText("White");
            String chooseColorBox = select.getFirstSelectedOption().getText();
            Assertions.assertThat("White").as("Выбран не правильный вариант").isEqualTo(chooseColorBox);


        }
    }

