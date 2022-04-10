package Laba1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class Test1 extends Base {
    @Test
    public void input() {
        String name = "Test User";
        String mail = "cekijil597@moonran.com";
        String currentAddress = "qwerty1256,12";
        String permAddress = "test,12";
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        try {
            WebElement cardElements = driver.findElement(
                    By.xpath("//h5[contains(text(), \"Elements\")]"));
            cardElements.click();

            WebElement textBoxInElement = driver.findElement(
                    By.xpath("//li[@id='item-0']"));
            textBoxInElement.click();

            WebElement firstNameFill = driver.findElement(
                    By.xpath("//input[@id='userName']"));
            firstNameFill.sendKeys(name);

            WebElement emailAddressFill = driver.findElement(
                    By.xpath("//input[@id='userEmail']"));
            emailAddressFill.sendKeys(mail);

            WebElement currentAddressFill = driver.findElement(
                    By.xpath("//textarea[@id='currentAddress']"));
            currentAddressFill.sendKeys(currentAddress);

            WebElement permanentAddressFill = driver.findElement(
                    By.xpath("//textarea[@id='permanentAddress']"));
            permanentAddressFill.sendKeys(permAddress);

            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");

            WebElement buttonSubmit = driver.findElement(
                    By.xpath("//button[@id='submit']"));
            buttonSubmit.click();

            WebElement rowName = driver.findElement(
                    By.xpath("//p[@id='name']"));
            String nameOut = rowName.getText();
            nameOut = nameOut.substring(nameOut.indexOf(":") + 1);


            WebElement rowEmail = driver.findElement(
                    By.xpath("//p[@id='email']"));
            String emailOut = rowEmail.getText();
            emailOut = emailOut.substring(emailOut.indexOf(":") + 1);

            WebElement rowCurrent = driver.findElement(
                    By.xpath("//p[@id='currentAddress']"));
            String currentOut = rowCurrent.getText();
            currentOut = currentOut.substring(currentOut.indexOf(":") + 1);

            WebElement rowPermanentAddress = driver.findElement(
                    By.xpath("//p[@id='permanentAddress']"));
            String permanentOut = rowPermanentAddress.getText();
            permanentOut = permanentOut.substring(permanentOut.indexOf(":") + 1);

            assertEquals(name, nameOut);
            assertEquals(mail, emailOut);
            assertEquals(currentAddress, currentOut);
            assertEquals(permAddress, permanentOut);
        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
