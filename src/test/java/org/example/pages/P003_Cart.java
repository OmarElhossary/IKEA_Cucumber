package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P003_Cart {
    public P003_Cart()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(xpath = "//*[@class=\"hnf-carousel-slide\"]//*[@src=\"https://www.ikea.com/global/assets/range-categorisation/images/product/lighting-li001.jpeg?imwidth=160\"]")
    public WebElement lightingLocator;
    @FindBy(xpath = "//*[@class=\"hnf-dropdown__column\"]//a[@data-tracking-label=\"2 | li002\"]")
    public WebElement lampsLocator;
    @FindBy(xpath = "//*[@class=\"plp-fragment-wrapper\"][3]//span[@class=\"plp-price-module__name-decorator\"]")
    public WebElement selectedProduct;
    @FindBy(xpath = "//*[@class=\"plp-fragment-wrapper\"][3]//div[@class=\"plp-mastercard__item plp-mastercard__button-container \"]/div[@class=\"plp-button-container\"]/button[@class=\"plp-btn plp-btn--small plp-btn--icon-emphasised\"]")
    public WebElement bagLocatorOut;
    @FindBy(xpath = "//*[@aria-label=\"Add to bag\"][@class=\"pip-btn pip-btn--emphasised pip-btn--fluid\"]")
    public WebElement bagLocatorIn;
    @FindBy(xpath = "//*[@class=\"hnf-svg-icon hnf-svg-bag-default hnf-btn__icon\"][@focusable=\"false\"]")
    public WebElement bag;
    @FindBy(xpath = "//*[@class=\"cart-ingka-quantity-stepper__input\"]")
    public WebElement quantity;












}
