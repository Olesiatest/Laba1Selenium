package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.fail;

public class Test8Selenide extends BaseSelenide{
    @Test
    public void modals() {
        try {

            $(By.xpath("//h5[contains(text(), \"Alerts, Frame & Windows\")]")).scrollIntoView(true).click();

            $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).scrollIntoView(true).click();

            $("#showSmallModal").click();

            String actualModalTitleDialog = $("#example-modal-sizes-title-sm").getText();
            String expectedModalTitleDialog = "Small Modal";
            Assertions.assertThat(expectedModalTitleDialog).as("Не верный результат").isEqualTo(actualModalTitleDialog);

            String actualModalTextDialog = $(".modal-body").getText();
            String expectedModalTextDialog = "This is a small modal. It has very less content";
            Assertions.assertThat(expectedModalTextDialog).as("Не верный результат").isEqualTo(actualModalTextDialog);

             $("#closeSmallModal").click();

            String isExistClassModalOpen = $("body").attr("class");
            if (isExistClassModalOpen.equals("modal-open")) {
                fail("Модальное окно открыто");
            }

        }catch (Exception e) {
            System.out.println("NotPassed: " + e.getMessage());
        }
    }
}
