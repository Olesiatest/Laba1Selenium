package Laba2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class Test2Selenide extends BaseSelenide {

  @Test
  public void checkBox2() {

    $(By.xpath("//h5[contains(text(), 'Elements')]")).scrollIntoView(true).click();

    $(By.xpath("//li[@id='item-1']")).scrollIntoView(true).click();

    $(By.xpath("//ol/li//button")).click();

    $(By.xpath("//ol//ol/li[last()]//button")).click();

    $(By.xpath("//label[@for='tree-node-wordFile']")).click();

    String wordFileNew = $(".text-success").getText();
    String expctedResult = "wordFile";
    assertEquals(expctedResult, wordFileNew);

  }
}


