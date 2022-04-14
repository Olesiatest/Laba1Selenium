package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.Thread.sleep;

public class Test4Selenide extends BaseSelenide{
    @Test
    public void windows() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
            $(By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]")).click();

            ((JavascriptExecutor) driver).executeScript("scroll(0,100)");
            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")).click();
            sleep(1000);

            $(By.xpath("//button[@id='tabButton']")).click();
            String defaultWindow = driver.getWindowHandle();
            String[] availableWindows = driver.getWindowHandles().toArray(new String[0]);
            for (int i = 0; i < availableWindows.length; i++) {
                if (!defaultWindow.equals(availableWindows[i])) {
                    driver.switchTo().window(availableWindows[i]);
                    break;
                }
                String sempleHeandingText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
                String expectedHeadingText = "This is a sample page";
                Assertions.assertThat(expectedHeadingText).as("Не корректный текст").isEqualTo(sempleHeandingText);
            }
    }
    }

