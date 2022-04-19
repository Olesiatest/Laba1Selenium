package Laba3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

  @Test
  public void fillRegisterForm() {
    MainPage mainPage = new MainPage();
    String actualResult = mainPage.clickOnMyAccountPage().clickOnRegisterPage()
        .fillFirstnameField("test")
        .fillLastnameField("Demchuk")
        .fillEmailField("tabamfbh576@aikusy.com")
        .fillTelephoneField("525124")
        .fillPasswordField("123456")
        .fillConfirmField("123456")
        .clickCheckBoxAgree()
        .clickOnSubmitButton()
        .textAccountPage();
    Assertions.assertThat("Your Account Has Been Created!").as("Ошибка").isEqualTo(actualResult);


  }

}
