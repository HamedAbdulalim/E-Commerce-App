package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.D01_registerStepDef.registeredemial;


public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert softassert = new SoftAssert();

    @Given("user go to login page")
    public void openLoginPage() {

        login.loginIcon.click();
    }

    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void enterValidEmailAndPassword(String valid, String email, String password) {

                login.enterEmail.sendKeys(registeredemial);
                login.enterpassword.sendKeys(password);

    }

    @And("user press on login button")
    public void pressLoginBtn() {

        login.loginBtn.click();
    }

    @Then("user login to the system successfully")
    public void assertSuccessfullyLogin() {
        softassert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softassert.assertTrue(login.myAccountTab.isDisplayed());
        softassert.assertAll();
    }

    @Then("user could not login to the system")
    public void assertUnsuccessfullyLogin() {
        String unsuccessfullyMsg = login.unSuccessMsg.getText();
        System.out.println(unsuccessfullyMsg);
        softassert.assertEquals(unsuccessfullyMsg.contains("Login was unsuccessful."), true);
        String Msgcolor = login.unSuccessMsg.getCssValue("color");
        String convertedcolor = Color.fromString(Msgcolor).asHex();
        softassert.assertEquals(convertedcolor, "#e4434b");
        softassert.assertAll();
    }

    @When("user login unsuccessfully with {string} {string} and {string}")
    public void userLoginUnsuccessfullyWithAnd(String arg0, String arg1, String password) {

        login.enterEmail.sendKeys(arg1+"we");
        login.enterpassword.sendKeys(password);
    }
}
