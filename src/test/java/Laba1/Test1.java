package Laba1;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Utils;

public class Test1 extends Base {

  @Test
  public void input() {
    String name = "Test User";
    String mail = "cekijil597@moonran.com";
    String currentAddress = "qwerty1256,12";
    String permAddress = "test,12";

    WebElement cardElements = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
    Utils.scrollToElement(driver, cardElements);
    cardElements.click();

    WebElement textBoxInElement = driver.findElement(
        By.id("item-0"));
    textBoxInElement.click();

    WebElement firstNameFill = driver.findElement(
        By.id("userName"));
    firstNameFill.sendKeys(name);

    WebElement emailAddressFill = driver.findElement(
        By.id("userEmail"));
    emailAddressFill.sendKeys(mail);

    WebElement currentAddressFill = driver.findElement(
        By.xpath("//textarea[@id='currentAddress']"));
    currentAddressFill.sendKeys(currentAddress);

    WebElement permanentAddressFill = driver.findElement(
        By.xpath("//textarea[@id='permanentAddress']"));
    permanentAddressFill.sendKeys(permAddress);

    WebElement buttonSubmit = driver.findElement(
        By.id("submit"));
    Utils.scrollToElement(driver, buttonSubmit);
    buttonSubmit.click();

    WebElement rowName = driver.findElement(
        By.id("name"));
    String nameOut = rowName.getText();
    nameOut = nameOut.substring(nameOut.indexOf(":") + 1);

    WebElement rowEmail = driver.findElement(
        By.id("email"));
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

    Assertions.assertThat(name)
        .as(String.format("%s Actual result is not equals expected result %s", name, nameOut))
        .isEqualTo(nameOut);

    Assertions.assertThat(mail)
        .as(String.format("%s Actual result is not equals expected result %s", mail, emailOut))
        .isEqualTo(emailOut);

    Assertions.assertThat(currentAddress)
        .as(String.format("%s Actual result is not equals expected result %s", currentAddress,
            currentOut))
        .isEqualTo(currentOut);

    Assertions.assertThat(permAddress)
        .as(String.format("%s Actual result is not equals expected result %s", permAddress,
            permanentOut))
        .isEqualTo(permanentOut);

  }
}

