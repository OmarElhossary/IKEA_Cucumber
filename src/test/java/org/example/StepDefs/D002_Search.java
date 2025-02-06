package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P001_Register;
import org.example.pages.P002_Search;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.StepDefs.D001_Register.Password;
import static org.example.StepDefs.D001_Register.email;
import static org.example.StepDefs.Hooks.driver;

public class D002_Search {

    P002_Search  search = new P002_Search();
    P001_Register register = new P001_Register();
    SoftAssert assertion = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    @Given("go to Login Page")
    public void goToLoginPage() {
        Hooks.driver.get("https://www.ikea.com/eg/en/profile/login/");
    }


    @And("User Should login with email and password")
    public void userShouldLoginWithEmailAndPassword() {
        register.existEmail.sendKeys(email);
        register.pass.sendKeys(Password);
    }

    @Given("Enter a product keyword in the search bar")
    public void enterAProductKeywordInTheSearchBar() {
        wait.until(ExpectedConditions.invisibilityOf(register.logIn));
        wait.until(ExpectedConditions.visibilityOf(search.searchBar));
        search.searchBar.sendKeys("wood");
    }

    @When("User Click the search icon.")
    public void userClickTheSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(search.searchButton));
        search.searchButton.click();
    }

    @Then("the products displayed related to the keyword")
    public void theProductsDisplayedRelatedToTheKeyword() {
        assertion.assertEquals(search.label.getText(), "\"wood\"");
        assertion.assertTrue(search.productWood_1.isDisplayed());
        assertion.assertTrue(search.productWood_1.getText().equals("Drawer front, 80x10 cm"),"Error Name");

    }

    @Given("Click on a random product displayed on the home page")
    public void clickOnARandomProductDisplayedOnTheHomePage() {
        wait.until(ExpectedConditions.invisibilityOf(register.logIn));
        wait.until(ExpectedConditions.visibilityOf(search.homePage));
        search.homePage.click();
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(StaleElementReferenceException.class)
                ;

        wait.until(
                d -> {

                    if (search.randomProduct.isDisplayed()) {
                        wait.until(ExpectedConditions.elementToBeClickable(search.randomProduct));
                        search.randomProduct.click();
                        return true;
                    }

                    return false;
                });

        wait.until(
                d -> {

                    if (search.product.isDisplayed() && search.product.isEnabled()) {
                        wait.until(ExpectedConditions.elementToBeClickable(search.product));
                        search.product.click();
                        return true;
                    }

                    return false;
                });

        wait.until(
                d -> {

                    if (search.productName.isDisplayed()) {
                        return true;
                    }

                    return false;
                });
        System.out.println(search.productName.getText());
        assertion.assertTrue(search.productName.getText().equals("Food container, set of 17, transparent/orange"),"Error Name");
        assertion.assertAll();
    }
}
