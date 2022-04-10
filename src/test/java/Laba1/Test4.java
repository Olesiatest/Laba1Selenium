package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test4 extends Base{
    @Test
    public void windows() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardAlertFrameWindows = driver.findElement(
                    By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]"));
            action.click(cardAlertFrameWindows).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,100)");
            WebElement browserWindowButton = driver.findElement(
                    By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
            action.click(browserWindowButton).build().perform();

            Thread.sleep(1000);

            WebElement newTabInBrowserWindows = driver.findElement(By.xpath("//button[@id='tabButton']"));
            action.click(newTabInBrowserWindows).build().perform();
            String defaultWindow = driver.getWindowHandle();
//            Set<String> availableWindows=driver.getWindowHandles();
            String[] availableWindows = driver.getWindowHandles().toArray(new String[0]);
            for (int i = 0; i < availableWindows.length; i++) {
                if (!defaultWindow.equals(availableWindows[i])) {
                    driver.switchTo().window(availableWindows[i]);
                    break;
                }

            }
            String sempleHeandingText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
            String expectedHeadingText = "This is a sample page";
            Assertions.assertThat(expectedHeadingText).as("Не корректный текст").isEqualTo(sempleHeandingText);
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());

        }
    }
}
