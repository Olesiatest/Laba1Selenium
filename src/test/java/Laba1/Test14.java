package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test14 extends Base{
    @Test
    public void practiceForm() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            ((JavascriptExecutor) driver).executeScript("return document.getElementById('fixedban').remove();");
            WebElement cardForms = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]"));
            action.click(cardForms).build().perform();
            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");


            WebElement clickMenuPracticeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']")));
            action.click(clickMenuPracticeButton).build().perform();

            ((JavascriptExecutor) driver).executeScript("scrollTo(0,document.body.scrollHeight)");
            ((JavascriptExecutor) driver).executeScript("return document.getElementById('submit').click();");


            String firstNameField = driver.findElement(By.xpath("//input[@id='firstName']")).getCssValue("border-color");
            String errorColor = "rgb(206, 212, 218)";
            Assertions.assertThat(errorColor).as("Ошибки нету").isEqualTo(firstNameField);

            String dateOfBirthInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).getAttribute("value");
            SimpleDateFormat formatForDate = new SimpleDateFormat("dd MMM yyyy",new Locale("en", "EN"));
            String currentDate = formatForDate.format(new Date());
            Assertions.assertThat(currentDate).as("Не верна дата").isEqualTo(dateOfBirthInput);

        }
    }

