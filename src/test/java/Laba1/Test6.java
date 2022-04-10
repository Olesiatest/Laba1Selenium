package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Test6 extends Base{
    @Test
    public void alertsSecond() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardAlertFrameWindows = driver.findElement(
                    By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]"));
            action.click(cardAlertFrameWindows).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,200)");
            WebElement alertWindowButton = driver.findElement(
                    By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"));
            action.click(alertWindowButton).build().perform();

            WebElement clickMeButtonInAlertWindowAfterFiveMinutes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='timerAlertButton']")));
            action.click(clickMeButtonInAlertWindowAfterFiveMinutes).build().perform();
            wait.until(ExpectedConditions.alertIsPresent());//*Ожидание елемента на протяжении 10 с.
            String actualTextInAlertSecond = driver.switchTo().alert().getText();
            String expectedTextInAlertSecond = "This alert appeared after 5 seconds";
            Assertions.assertThat(expectedTextInAlertSecond).as("Не верный результат").isEqualTo(actualTextInAlertSecond);
            driver.switchTo().alert().accept();//*Закриття Алерта(модальне вікно).
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }

    }
}
