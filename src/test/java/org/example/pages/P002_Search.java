package org.example.pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P002_Search {

    public P002_Search()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(xpath = "//*[@id=\"ikea-search-input\"]")
    public WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"search-box__searchbutton\"][@class=\"search-btn search-box__button double search\"]")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@class=\"search-summary__content\"]/h1")
    public WebElement label;
    @FindBy(xpath = "//*[@class=\"plp-fragment-wrapper\"][1]//span[@class=\"plp-price-module__description\"]")
    public WebElement productWood_1;
    @FindBy(xpath = "//*[@href=\"https://www.ikea.com/eg/en/\"][@class=\"hnf-link\"]")
    public WebElement homePage;
    @FindBy(xpath = "//*[@class=\"c1s88gxp a1wqrctr\"][2]//img[@src=\"https://www.ikea.com/images/14/18/14187cf01fe352ce9442787de4004068.jpg?f=s\"]")
    public WebElement randomProduct;
    @FindBy(xpath = "//*[@class=\"plp-fragment-wrapper\"][2]//div[@class=\"plp-mastercard__item plp-mastercard__price \"]//span[@class=\"plp-price-module__name-decorator\"]")
    public WebElement product;
    @FindBy(xpath = "//*[@class=\"pip-header-section__description-text\"]")
    public WebElement productName;






}
