package Laba2;

import static com.codeborne.selenide.Selenide.$;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test8Selenide extends BaseSelenide {

  @Test
  public void modals() {
    $(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]")).scrollIntoView(true).click();
    $(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).scrollIntoView(true)
        .click();

    $("#showSmallModal").click();

    String actualModalTitleDialog = $("#example-modal-sizes-title-sm").getText();
    String expectedModalTitleDialog = "Small Modal";
    Assertions.assertThat(expectedModalTitleDialog)
        .as(String.format("%s Actual result is not equal %s", expectedModalTitleDialog,
            actualModalTitleDialog))
        .isEqualTo(actualModalTitleDialog);

    String actualModalTextDialog = $(".modal-body").getText();
    String expectedModalTextDialog = "This is a small modal. It has very less content";
    Assertions.assertThat(expectedModalTextDialog)
        .as(String.format("%s Actual result is not equal %s", expectedModalTextDialog,
            actualModalTextDialog))
        .isEqualTo(actualModalTextDialog);

    $("#closeSmallModal").click();
    boolean theModalIsNotOpen = Boolean.parseBoolean($("body").getAttribute("class"));
    Assertions.assertThat(theModalIsNotOpen)
        .as(String.format("%b Actual result is not equal true", theModalIsNotOpen))
        .isTrue();
  }
}


