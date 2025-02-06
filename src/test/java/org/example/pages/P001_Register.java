package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// locators
public class P001_Register {
    public P001_Register()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    public void closeOverlayIfPresent() {

        List<WebElement> overlayElements = Hooks.driver.findElements(By.xpath("//*[@class=\"ins-responsive-banner-image ins-element-content ins-sample-element-children\"]"));
        if (overlayElements.size() > 0) {
            WebElement overlayCloseButton = Hooks.driver.findElement(By.xpath("//*[@select-border-sides=\"border\"][@select-border-sides=\"border\"][@class=\"ins-element-content ins-selectable-element\"]"));
            overlayCloseButton.click();
        }
    }


    @FindBy(xpath = "//*[@class=\"hnf-content-container hnf-header__container hnf-page-container__main\"]/ul[@class=\"hnf-header__icons\"]/li[@class=\"hnf-header__profile-link\"]/a[1]")
     public WebElement signAndLoginIcon;
    @FindBy(xpath = "//*[@class=\"skapa-mvagent-wrapper-prefix-btn skapa-mvagent-wrapper-prefix-btn--secondary skapa-mvagent-wrapper-prefix-btn--fluid\"]")
    public WebElement createNewAccount;
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    public WebElement firstName;
    @FindBy(xpath = "//*[@id=\"last-name\"]")
    public WebElement lastName;
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement emailAddress;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement emailPassword;
    @FindBy(xpath = "//*[@name=\"checkboxname\"]")
    public WebElement checkBox;
    @FindBy(xpath = "//*[@class=\"pp-skapa__btn pp-skapa__btn--primary pp-skapa__btn--fluid sign-up-content-right_createAccount__Jwuq1\"]")
    public WebElement createAccountButton;
//    @FindBy(xpath = "//*[@class=\"ins-responsive-banner-image ins-element-content ins-sample-element-children\"]")
//    public WebElement pop;
//    @FindBy(xpath = "//*[@select-border-sides=\"border\"][@select-border-sides=\"border\"][@class=\"ins-element-content ins-selectable-element\"]")
//    public WebElement closePop;
    @FindBy(xpath = "//*[@data-testid=\"privacy-policy-link\"]")
    public WebElement privacy;
    @FindBy(xpath ="//*[@class=\"pp-skapa__list-view-item__title\"]")
    public WebElement logOut;
    @FindBy(xpath = "//*[@name=\" Email (username)\"]")
    public WebElement existEmail;
    @FindBy(xpath = "//*[@data-testid=\"password\"]")
    public WebElement pass;
    @FindBy(xpath = "//*[@class=\"login-page-content-right_formContent__q3Mmp\"]/*[@class=\"pp-skapa__btn pp-skapa__btn--primary pp-skapa__btn--fluid\"]")
    public WebElement logIn;

}
