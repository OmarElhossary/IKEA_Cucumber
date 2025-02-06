package org.example.StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P001_Register;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.StepDefs.Hooks.driver;

public class D001_Register {

    P001_Register register= new P001_Register();
     static Faker fake = new Faker();
    public static  String  Password =fake.internet().password(12,15,true,true,true);
     public static String email = fake.internet().safeEmailAddress();

    @Given("User Click on Register and Login Icon")
    public void userClickOnRegisterLoginIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(register.signAndLoginIcon));
        register.signAndLoginIcon.click();

    }
    @When("User Navigate to the Create Account page")
    public void userNavigateToTheCreateAccountPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        register.closeOverlayIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(register.createNewAccount));
        register.createNewAccount.click();
    }

    @And("Enter a Valid Personal Data")
    public void enterAValidPersonalData() {
        register.closeOverlayIfPresent();
        register.firstName.sendKeys(fake.name().firstName());
        register.lastName.sendKeys(fake.name().lastName());
        register.emailAddress.sendKeys(email);
        register.emailPassword.sendKeys(Password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        register.privacy.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        register.checkBox.click();
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("arguments[0].click();",register.checkBox);

    }
    @And("User Can register Successfully")
    public void userCanRegisterSuccessfully()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        register.closeOverlayIfPresent();
        wait.until(ExpectedConditions.visibilityOf(register.createAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(register.createAccountButton));
        register.createAccountButton.click();

    }

    @And("User logout")
    public void userLogout() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        register.closeOverlayIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(register.logOut));
        register.logOut.click();
    }

    @And("User Should login with Exist email and password")
    public void userShouldLoginWithExistEmailAndPassword() {

        register.existEmail.sendKeys(email);
        register.pass.sendKeys(Password);
//        register.closeOverlayIfPresent();
    }

    @Then("User login Successfully")
    public void userLoginSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        register.closeOverlayIfPresent();
        wait.until(ExpectedConditions.visibilityOf(register.logIn));
        wait.until(ExpectedConditions.elementToBeClickable(register.logIn));
        register.logIn.click();

    }
}
