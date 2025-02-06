package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P003_Cart;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.StepDefs.Hooks.driver;

public class D003_Cart {
    P003_Cart cart = new P003_Cart();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    SoftAssert Assert = new SoftAssert();

    @Given("Click on a lighting category on the home page And go to lamp")
    public void clickOnALightingCategoryOnTheHomePage() {
        wait.until((ExpectedConditions.elementToBeClickable(cart.lightingLocator)));
        cart.lightingLocator.click();
        wait.until((ExpectedConditions.elementToBeClickable(cart.lampsLocator)));
        cart.lampsLocator.click();
    }


    @When("Click on “Add to Bag” button on a random product")
    public void clickOnAddToBagButtonOnARandomProduct() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
        ;

        wait.until(
                d -> {

                    if (cart.bagLocatorOut.isDisplayed()) {
                        wait.until(ExpectedConditions.elementToBeClickable(cart.bagLocatorOut));
                        cart.bagLocatorOut.click();
                        return true;
                    }

                    return false;
                });

//        wait.until((ExpectedConditions.visibilityOf(cart.bagLocatorOut)));
     //   wait.until((ExpectedConditions.elementToBeClickable(cart.bagLocatorOut)));
        Assert.assertTrue(cart.bagLocatorOut.isDisplayed());

        cart.bagLocatorOut.click();
    }

    @And("Click on the same product and add it to the bag")
    public void clickOnTheSameProductAndAddItToTheBag() {
        wait.until((ExpectedConditions.elementToBeClickable(cart.selectedProduct)));
        cart.selectedProduct.click();
        wait.until(
                d -> {

                    if (cart.bagLocatorIn.isDisplayed()) {
                        wait.until(ExpectedConditions.elementToBeClickable(cart.bagLocatorIn));
                        cart.bagLocatorIn.click();
                        return true;
                    }

                    return false;
                });
//        wait.until((ExpectedConditions.visibilityOf(cart.bagLocatorIn)));
//        wait.until((ExpectedConditions.elementToBeClickable(cart.bagLocatorIn)));
        Assert.assertTrue(cart.bagLocatorIn.isDisplayed());
        cart.bagLocatorIn.click();

    }

    @Then("Ensure the quantity displayed in the bag")
    public void ensureTheQuantityDisplayedInTheBag() {
        wait.until(
                d -> {

                    if (cart.bag.isDisplayed()) {
                        wait.until(ExpectedConditions.elementToBeClickable(cart.bag));
                        cart.bag.click();
                        return true;
                    }

                    return false;
                });
//        wait.until((ExpectedConditions.elementToBeClickable(cart.bag)));
//        cart.bag.click();
        wait.until((ExpectedConditions.visibilityOf(cart.quantity)));

        if(cart.quantity.getText().equals("2"))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

        Assert.assertAll();
    }
}
