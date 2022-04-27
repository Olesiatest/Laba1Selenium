package Laba2;

import static com.codeborne.selenide.Selenide.$;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1Selenide extends BaseSelenide {

  @Test
  public void input1() {
    String name = "TestName";
    String mail = "testEmail@gmail.com";
    String curAdd = "testCurAdd";
    String perAdd = "testPerAdd";

    $(By.xpath("//h5[contains(text(), 'Elements')]")).scrollIntoView(true).click();
    $("#item-0").scrollIntoView(true).click();

    $("#userName").setValue(name);
    $("#userEmail").setValue(mail);
    $("#currentAddress").setValue(curAdd);
    $("#permanentAddress").setValue(perAdd);

    $("#submit").scrollIntoView(true).click();

    String outName = $("#output").find("#name").getText();
    String outEmail = $("#output").find("#email").getText();
    String outCurAddress = $("#output").find("#currentAddress").getText();
    String outPerAddress = $("#output").find("#permanentAddress").getText();

    outName = outName.substring(outName.indexOf(":") + 1);
    outEmail = outEmail.substring(outEmail.indexOf(":") + 1);
    outCurAddress = outCurAddress.substring(outCurAddress.indexOf(":") + 1);
    outPerAddress = outPerAddress.substring(outPerAddress.indexOf(":") + 1);

    Assertions.assertThat(name)
        .as(String.format("%s Actual result is not equals expected result %s", name, outName))
        .isEqualTo(outName);

    Assertions.assertThat(mail)
        .as(String.format("%s Actual result is not equals expected result %s", mail, outEmail))
        .isEqualTo(outEmail);

    Assertions.assertThat(outCurAddress)
        .as(String.format("%s Actual result is not equals expected result %s", outCurAddress,
            outCurAddress))
        .isEqualTo(outCurAddress);

    Assertions.assertThat(outPerAddress)
        .as(String.format("%s Actual result is not equals expected result %s", outPerAddress,
            outPerAddress))
        .isEqualTo(outPerAddress);
  }
}
