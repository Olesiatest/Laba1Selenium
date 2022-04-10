package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Test10 extends Base{
    @Test
    public void tabs() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardWidget = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
            action.click(cardWidget).build().perform();

            ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
            WebElement tabsButtonInWidget = driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-5']"));
            action.click(tabsButtonInWidget).build().perform();
            WebElement elementWhatTabsInWidget = driver.findElement(By.xpath("//a[@id='demo-tab-what']"));

            List<WebElement> tabsListWidget = driver.findElements(By.xpath("//a[@role='tab']"));
            List<String> activeTexts = Arrays.asList("What", "Origin", "Use");
            for(WebElement tab : tabsListWidget){
                if(activeTexts.contains(tab.getText())){
                    assert !tab.getAttribute("class").contains("disabled");
                }else assert tab.getAttribute("class").contains("disabled");
            }

        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
