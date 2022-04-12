package Laba2;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Fail.fail;
import static org.testng.AssertJUnit.assertEquals;

public class Test1Selenide extends BaseSelenide {

    @Test
    public void input1() {
        String name = "TestName";
        String mail = "testEmail@gmail.com";
        String curAdd = "testCurAdd";
        String perAdd = "testPerAdd";

        try {
            $(By.xpath("//h5[contains(text(), \"Elements\")]")).scrollIntoView(true).click();
            $("#item-0").click();

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

            Assertions.assertThat(name).as("etstseetse").isEqualTo(outName);
            Assertions.assertThat(mail).isEqualTo(outEmail);
            Assertions.assertThat(curAdd).isEqualTo(outCurAddress);
            Assertions.assertThat(perAdd).isEqualTo(outPerAddress);

        }catch (Exception e) {
            fail("Error ", e.getMessage());
        }
    }
}