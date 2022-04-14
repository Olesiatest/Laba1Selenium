package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class Test8 extends Base{
    @Test
    public void modals() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            WebElement cardAlertFrameWindows = driver.findElement(
                    By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
            action.click(cardAlertFrameWindows).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
            WebElement modalDialogButton = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
            action.click(modalDialogButton).build().perform();

            WebElement smallModalButton = driver.findElement(By.xpath("//button[@id='showSmallModal']"));
            action.click(smallModalButton).build().perform();

            String actualModalTitleDialog = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']")).getText();
            String expectedModalTitleDialog = "Small Modal";
            Assertions.assertThat(expectedModalTitleDialog).as("Не верный результат").isEqualTo(actualModalTitleDialog);

            String actualModalTextDialog = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
            String expectedModalTextDialog = "This is a small modal. It has very less content";
            Assertions.assertThat(expectedModalTextDialog).as("Не верный результат").isEqualTo(actualModalTextDialog);

            WebElement closeModalWindow = driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
            action.click(closeModalWindow).build().perform();

            String isExistClassModalOpen = driver.findElement(By.tagName("body")).getAttribute("class");

            if (isExistClassModalOpen.equals("modal-open")) {
                fail("Модальное окно открыто");
            }

        }


    }

