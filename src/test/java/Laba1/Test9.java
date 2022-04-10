package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test9 extends Base{
    @Test
    public void progressBar() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
            action.click(cardWidget).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,600)");
            WebElement progressBurButtonInWidget = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
            action.click(progressBurButtonInWidget).build().perform();
            WebElement elementStarButtonProgressBur = driver.findElement(By.xpath("//button[@id='startStopButton']"));
            action.click(elementStarButtonProgressBur).build().perform();

            WebElement progressBar = driver.findElement(By.xpath("//div[@role='progressbar']"));
            String ariaValuenow = progressBar.getAttribute("aria-valuenow");
            String ariaValuemax = progressBar.getAttribute("aria-valuemax");
            //*ariaValuenow=5;

            while (Integer.parseInt(ariaValuenow) <= Integer.parseInt(ariaValuemax)) {
                Thread.sleep(100);
                ariaValuenow = progressBar.getAttribute("aria-valuenow");
                if (Integer.parseInt(ariaValuenow) == Integer.parseInt(ariaValuemax)) {
                    break;
                }
            }
            Thread.sleep(1000);

            WebElement resetButtonProgressBar = driver.findElement(By.xpath("//button[@id='resetButton']"));
            resetButtonProgressBar.click();
            ariaValuenow = progressBar.getAttribute("aria-valuenow");
            Assertions.assertThat(Integer.parseInt(ariaValuenow)).as("Прогрес бар равен 0").isEqualTo(0);
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
